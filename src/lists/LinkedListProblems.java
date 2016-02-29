package lists;
import java.util.ArrayList;
import java.util.List;


public class LinkedListProblems {

	
	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		List<Node> nodes = new ArrayList<Node>() {{
			add(new Node(1));
			add(new Node(2));
			add(new Node(3));
			add(new Node(4));
			add(new Node(5));
			add(new Node(6));
			add(new Node(7));
			add(new Node(8));
			add(new Node(9));
			add(new Node(10));
		}};
		
		Node head = nodes.get(0);		
		for( int i = 1; i < nodes.size(); i++) {
			insert(nodes.get(i), head, i);
		}
		System.out.println(head);
		insert(new Node(100), head, 4);
		System.out.println(head);
		
		for( int i = 0; i < 4; i++) {
			head = remove(i, head);
			printList(head); System.out.println();
		}
		
		System.out.println("*********************************************************************************************************");
		head = reverseRecursive(head);
		System.out.println(head);
		System.out.println("*********************************************************************************************************");
		head = reverseIterative(head);
		System.out.println(head);;
	}
	
	public static Node insert(Node n, Node head, int atPosition) {
		   
		    // 0 is the beginning position		
			if( n != null && atPosition == 0) {
				n.setNextNode(head);
				head = n;
			}
			if(head != null) {
				if ( atPosition == 1 ) {
					n.setNextNode(head.getNextNode());
					head.setNextNode(n);					
				}
				else {
					insert(n, head.getNextNode(), atPosition - 1);
				}
			}
			return head;			
	}
	
	public static Node remove(int atPosition, Node head) {
		//Head position is ZERO.
		if(atPosition == 0 && head != null) {
			head = head.getNextNode();
		}
		else if( atPosition == 1 && head != null) {
			if(head.getNextNode() != null) {
				head.setNextNode(head.getNextNode().getNextNode());
			}
		}
		else {
			remove(atPosition - 1, head.getNextNode());
		}
		return head;
	}
	
	public static void printList(Node n) {
		if(n != null) {
			System.out.print(n.getValue() + " --> ");
			printList(n.getNextNode());
		}		
	}
	
	public static Node reverseRecursive(Node head) {		
		
		if(head == null) {
			// do nothing.
		}		
		else if(head.getNextNode() == null) {
			return head;
		}
		else{
			Node newHead = reverseRecursive(head.getNextNode());
			Node temp = newHead;
			while(temp.getNextNode() != null) {
				temp = temp.getNextNode();
			}
			temp.setNextNode(head);
			head.setNextNode(null);
			head = newHead;
		}
		return head;
	}
	
	public static Node reverseIterative(Node head){

		if(head == null) {
			return null;
		}
		if(head.getNextNode() == null) {
			return head;
		}
		if(head.getNextNode().getNextNode() == null) {
			head.getNextNode().setNextNode(head);
			head = head.getNextNode();
			head.getNextNode().setNextNode(null);
			return head;
		}
		
		Node one = head;		
		Node two = one.getNextNode();
		head = two.getNextNode();		
		one.setNextNode(null); //Imp
		
		while(head.getNextNode() != null) {
			two.setNextNode(one);
			one = two;
			two = head;
			head = head.getNextNode();			
		}		
		two.setNextNode(one); //Imp
		head.setNextNode(two); //Imp
		return head;
	}
	
	private static class Node {
		int value;
		Node nextNode;
		
		Node(int n){
			value = n;
			nextNode = null;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
		public String toString() {
			String s = this.value + " --> ";
			if(this.nextNode == null) {
				s += "NULL";				
			}
			else {
				s += nextNode;
			}
			return s;
		}
	}
}
