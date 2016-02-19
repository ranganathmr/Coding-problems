
public class CircularQueue {
	
	private int size = 10;

	private int[] storage;
	
	private int front = 0;
	
	private int back = 0;
	
	private int count = 0;
	
	public CircularQueue() {
		storage = new int[size];
	}
	
	public CircularQueue(int size) {
		this.size = size;
		storage = new int[size];
	}
	
	public void add(int data){
		if( !full() ) {
			storage[front] = data;
			System.out.println(String.format("Added %s to pos: %s", data, (front % size)) );
			front = (front + 1) % size;
			count++;
		}else {
			System.out.println("Full");
		}
	}
	
	public int remove() {
		if( !empty() ){
			int removedItem = storage[back];
			System.out.println(String.format("removed %s from pos: %s", removedItem, (back% size)) );
			back = (back + 1) % size;
			count--;
			return removedItem;
		}
		// This is timepass value returned.
		return Integer.MAX_VALUE;
	}
	
	public boolean empty() {
		return count == 0;
	}
	
	public boolean full() {
		return count == size;
	}
}
