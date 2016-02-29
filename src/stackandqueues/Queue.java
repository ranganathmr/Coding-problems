package stackandqueues;
import lists.LinkedList;

public class Queue<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	
	public void add(T data) {
		storage.insertAtTail(data);
	}
	
	public T peek(){
		return storage.peekData();
	}
	
	public T remove() {
		return storage.removeFromHead();
	}
	
	public void clear() {
		while(storage.peekData() != null) {
			storage.removeFromHead();
		}
	}
	
	public void print(){
		storage.print();
	}
}
