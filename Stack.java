
public class Stack<T> {
	
	private LinkedList<T> storage = new LinkedList<T>();
	
	private int count;
	
	public void push(T data) {
		count++;
		storage.insertAtHead(data);
	}
	
	public T peek() {
		if(count == 0) {
			return null;
		}
		return storage.peekData();
	}
	
	public T pop(){
		count--;
		return storage.removeFromHead();
	}
	
	
	public LinkedList<T> getStorage(){
		return storage;
	}
}
