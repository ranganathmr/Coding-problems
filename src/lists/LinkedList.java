package lists;

public class LinkedList<T> {
	
	private Node<T> head;
	
	private Node<T> tail;
	
	public void insertAtHead(T data) {
		Node<T> node = new Node<T>(data, head);
		head = node;
		if(tail == null) {
			tail = head;
		}
	}
	
	public void insertAtTail(T data) {
		Node<T> node = new Node<T>(data);
		if(tail != null) {
			tail.setNext(node);
		} 
		tail = node;
		if(head == null) {
			head = tail;
		}
	}
	
	public T peekData() {
		if(head == null) {
			return null;
		}
		return head.getData();
	}
	
	public T removeFromHead() {
		if(head == null) {
			return null;
		}
		Node<T> temp = head;
		head = head.getNext();
		return temp.getData();
	}
	
	public void reverse(){
		
		if(head == null 
				|| head.getNext() == null) {
			// Nothing needs to be done.
		} else {
			tail = head;
			Node<T> header = head;
			Node<T> one = header.getNext();
			Node<T> two = one.getNext();

			while(two != null){
				one.setNext(header);
				header = one;
				one = two;
				two = two.getNext();
			}
			one.setNext(header);
			head.setNext(null);
			head = one;
		}
	}
	
	public void print(){
		print(head);
	}
	
	private void print(Node<T> node) {
		if(node != null) {
			System.out.print("[" + node.getData() + "]-->");
			print(node.getNext());
		}
	}
	
	public Node<T> head(){
		return head;
	}
	
	public Node<T> tail(){
		return tail;
	}
	
	public static <T> LinkedList<T> build(T[] array){
		if(array == null) {
			return null;
		}
		LinkedList<T> list = new LinkedList<>();
		for(T i: array) {
			list.insertAtTail(i);
		}
		return list;
	}
}
