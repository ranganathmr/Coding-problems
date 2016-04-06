package multithreaded;

public class PubSub {
	
	
	public static void main(String[] args) throws Exception {
		BlockingQueue<Integer> queue = new BlockingQueueImpl<Integer>(10);
		
		Producer p1 = new Producer(queue, 5);
		Producer p2 = new Producer(queue, 5);
		Producer p3 = new Producer(queue, 5);
		
		Consumer c1 = new Consumer(queue, 7);
		Consumer c2 = new Consumer(queue, 8);
		
		Thread t1 = new Thread(p1);
		Thread t4 = new Thread(c1);
		
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t5 = new Thread(c2);
		
		t1.start();
		t4.start();
		t2.start();
		t3.start();
		t5.start();

		t4.join();
		t1.join();
		t2.join();
		t3.join();
		t5.join();
		
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
				Thread.sleep(0);
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
				Thread.sleep(0);
			} catch (InterruptedException e) {
				System.out.println("Sleep-Error");
			}
		}
	}
}
