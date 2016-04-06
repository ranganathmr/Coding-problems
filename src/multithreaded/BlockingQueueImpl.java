package multithreaded;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueImpl<T> implements BlockingQueue<T> {

	private List<T> storage = new LinkedList<>();
	private int limit = 100; // Default

	private static final Integer n = 10;
	
	public BlockingQueueImpl(int limit) {
		this.limit = limit;
	}

	@Override
	public void put(T element) {
		while (true) {
			synchronized (n) {
				if (storage.size() == limit) {
					try {
						n.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}

				/**
				 * This is a re-entrant lock. When the thread waits, the outer
				 * monitor/lock is relinquished. So its important to obtain lock
				 * again, so that we don't overflow queue size. **This may
				 * create starvation** (especially when put is called again).
				 */
				synchronized (n) {
					if (storage.size() < limit) {
						boolean isEmpty = storage.isEmpty();
						storage.add(element);
						// WARN: for debugging
						if (storage.size() > limit) {
							System.out.println("Exceeded");
						}

						if (isEmpty) {
							n.notifyAll();
						}
						break;
					}
				}
			}
		}
	}

	@Override
	public T take() {
		T result = null;
		while (true) {
			synchronized (n) {
				if (storage.size() == 0) {
					try {
						n.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}

				synchronized (n) {
					if (!storage.isEmpty()) {
						boolean isFull = storage.size() == limit;
						result = storage.remove(0);
						if (isFull) {
							n.notifyAll();
						}
						break;
					}
				}
			}
		}
		return result;
	}
}


