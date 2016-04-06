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
		synchronized (n) {
			while (storage.size() == limit) {
				try {
					n.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			boolean isEmpty = storage.isEmpty();
			storage.add(element);
			
			//WARN: Debug msg
			if (storage.size() > limit) {
				System.out.println("Exceeded");
			}
			if (isEmpty) {
				n.notifyAll();
			}
		}
	}

	@Override
	public T take() {
		T result = null;
		synchronized (n) {
			while (storage.size() == 0) {
				try {
					n.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

			boolean isFull = (storage.size() == limit);
			result = storage.remove(0);
			if (isFull) {
				n.notifyAll();
			}
		}
		return result;
	}
}


