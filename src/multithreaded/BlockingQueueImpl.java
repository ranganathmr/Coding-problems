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
			if (storage.size() == limit) {
				try {
					n.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			
			/**
			 * This is a re-entrant lock.
			 * When the thread waits, the outer monitor/lock is relinquished.
			 * So its important to obtain lock again, so that we don't overflow queue size.
			 *    **This may create starvation** (especially when put is called again).
			 */
			synchronized (n) {
				boolean isEmpty = storage.isEmpty();
				if(storage.size() < limit){
					storage.add(element);
				} else {
					put(element);
				}
			
				//WARN: for debugging
				if(storage.size() > limit) {
					System.out.println("Exceeded");
				}
				
				if (isEmpty) {
					n.notifyAll();
				}
			}
		}
	}

	@Override
	public T take() {
		T result = null;
		synchronized (n) {
			if (storage.size() == 0) {
				try {
					n.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			
			synchronized (n) {
				boolean isFull = storage.size() == limit;
				if(!storage.isEmpty()) {
					result = storage.remove(0);
				}else {
					result = take();
				}
			
				if (isFull) {
					n.notifyAll();
				}
			}
		}
		return result;
	}
}


