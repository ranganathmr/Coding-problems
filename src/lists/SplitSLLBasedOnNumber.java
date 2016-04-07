package lists;


public class SplitSLLBasedOnNumber {
	
	public static void main(String[] args) {
		Integer[] array = {5, 6, 7, 2, 3, 4, 4, 4, 5, 7, 10, -1};
		LinkedList<Integer> list = LinkedList.<Integer>build(array);
		splitListOnNumber(list, 4);
	}
	
	/**
	 * This assumes the number "N" is present in the list atleast once.
	 * @param list - list to split.
	 * @param n - the number based on which the list will be split.
	 * @return
	 */
	public static Node<Integer> splitListOnNumber(LinkedList<Integer> list, int n){
		Node<Integer> smaller = null;
		Node<Integer> bigger = null;
		Node<Integer> head = list.head();
		Node<Integer> numbers = null;
		Node<Integer> next = null;
		
		while(head != null){
			next = head.getNext();
			if(head.getData() == n){
				if(numbers == null){
					numbers = new Node<Integer>(head.getData());
				} else {
					head.setNext(numbers);
					numbers = head;
				}
			}
			if(head.getData() > n){
				if(bigger == null){
					bigger = new Node<Integer>(head.getData());
				} else {
					head.setNext(bigger);
					bigger = head;
				}

			}
			if(head.getData() < n){
				if(smaller == null){
					smaller = new Node<Integer>(head.getData());
				} else {
					head.setNext(smaller);
					smaller = head;
				}

			}
			head = next;
		}
		if(smaller == null) {
			Node<Integer> numbersTail = tail(numbers);
			numbersTail.setNext(bigger);
			print(numbers);
			return numbers;
		} else {
			Node<Integer> smallerTail = tail(smaller);
			Node<Integer> numbersTail = tail(numbers);
			smallerTail.setNext(numbers);
			numbersTail.setNext(bigger);
			print(smaller);
			return smaller;
		}
		
	}
	
	private static Node<Integer> tail(Node<Integer> node){
		Node<Integer> prev = null;
		while(node != null){
			prev = node;
			node = node.getNext();
		}
		return prev;
	}
	
	private static void print(Node<Integer> n){
		if(n != null){
			System.out.print("[" +  n.getData() +"]-->");
			print(n.getNext());
		}
	}
}
