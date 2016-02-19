
public class LinkedList<T> {
	
	private Node<T> head;
	
	private Node<T> tail;
	
	public void insertAtHead(T data) {
		Node<T> node = new Node<T>();
		node.setData(data);
		node.setNext(head);
		head = node;
		if(tail == null) {
			tail = head;
		}
	}
	
	public void insertAtTail(T data) {
		Node<T> node = new Node<T>();
		node.setData(data);
		node.setNext(null);
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
			System.out.print(node.getData() + " ");
			print(node.getNext());
		}
	}
	
	public static class Node<T> {
		
		private T data;
		
		private Node<T> next;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}

}
