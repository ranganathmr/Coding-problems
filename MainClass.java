import java.util.UUID;


public class MainClass {
	
	public static enum Test {
		Credit,
		Debit;
		
	}
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		//System.out.println(Test.valueOf("credit").name());
		//stackExample();
		//queueExample();
//		final String s = new String(new char[] { 48});
//		System.out.print(s);
		//circularQueue();
		
	}
	
	private static void circularQueue() {
		CircularQueue q = new  CircularQueue(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		q.add(10);
		q.add(11);
		q.add(12);
		q.add(13);
		q.remove();
		q.remove();
		q.remove();
		q.remove();
	}
	
	private static void stackExample() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	private static void queueExample() {
		Queue<Integer> q = new Queue<Integer>();
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());

	}

}
