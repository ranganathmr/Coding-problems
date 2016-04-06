package multithreaded;

import java.util.LinkedList;
import java.util.List;

public class PubSub {
	
	private static final int QUEUE_LIMIT = 10;
	private static final int P_AND_C_LIMIT = 100;
	private static final int NO_OF_P_AND_C= 100;
	private static final int PRODUCER_SLEEP = 20;
	private static final int CONSUMER_SLEEP = 40;
	
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Started");
		BlockingQueue<Integer> queue = new BlockingQueueImpl<Integer>(QUEUE_LIMIT);

		List<Thread> list = new LinkedList<>();
		for(int i = 0; i < NO_OF_P_AND_C; i++){
			list.add(new Thread(new Producer(queue, P_AND_C_LIMIT)));
			list.add(new Thread(new Consumer(queue, P_AND_C_LIMIT)));
		}
		for(Thread t: list){
			t.start();
		}
		for(Thread t: list){
			t.join();
		}
		
		System.out.println("Done");
	}
	
	private static class Producer implements Runnable{

		private BlockingQueue<Integer> queue;
		
		private int count;
		
		public Producer(BlockingQueue<Integer> queue, int n) {
			this.queue = queue;
			this.count = n;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < count; i++) {
				queue.put(i);
				sleep();
			}
		}
		
		private void sleep() {
			try {
				Thread.sleep(PRODUCER_SLEEP);
			} catch (InterruptedException e) {
				System.out.println("Sleep-Error");
			}
		}

	}
	
	private static class Consumer implements Runnable{

		private BlockingQueue<Integer> queue;
		
		private int count;
		
		public Consumer(BlockingQueue<Integer> queue, int n) {
			this.queue = queue;
			this.count = n;
		}
		
		@Override
		public void run() {
			int i = count;
			while(i > 0) {
				queue.take();
				i--;
				sleep();
			}
		}
		
		private void sleep() {
			try {
				Thread.sleep(CONSUMER_SLEEP);
			} catch (InterruptedException e) {
				System.out.println("Sleep-Error");
			}
		}
	}
}
