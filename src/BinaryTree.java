import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;


public class BinaryTree {
	
	private static final String SPACE = " ";
	
	public static Node<Integer> buildBST(List<Integer> list){
		if(list == null) {
			throw new IllegalArgumentException("Bad");
		}
		
		Node<Integer> root = null;		
		for(Integer element: list) {		
			root = insertNode(root, element);
		}
		
		return root;
	}
	
	private static Node<Integer> insertNode(Node<Integer> node, Integer value) {
		
		if( node == null) {
			return new Node<Integer>(value , null, null);
		}
		if(node.getValue() >= value) {
			node.setLeft(insertNode(node.getLeft(), value));
		} else {
			node.setRight(insertNode(node.getRight(), value));
		}
		return node;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {{
			add(5);
			add(7);
			add(3);
			add(2);
			add(9);
			add(10);
		}};		
		Node<Integer> root = BinaryTree.buildBST(list);
//		BinaryTree.inOrder(root);
//		System.out.println();
//		BinaryTree.preOrder(root);
//		System.out.println();
//		BinaryTree.postOrder(root);
//		System.out.println();
		System.out.println(BinaryTree.maxdepth(root));
//		System.out.println();		
//		
//		// Construct a BinaryTree
//		Node<Integer> rootNonBST = new Node<Integer>(10, null, null);
//		Node<Integer> rootLeft = BinaryTree.insertNode(rootNonBST, true, 12);
//		Node<Integer> rootRight = BinaryTree.insertNode(rootNonBST, false, 5);
//		
//		Node<Integer> rootLeftLeft = BinaryTree.insertNode(rootLeft, true, 14);
//		Node<Integer> rootLeftRight = BinaryTree.insertNode(rootLeft, false, 11);
//		Node<Integer> rootRightLeft = BinaryTree.insertNode(rootRight, true, 3);
//		Node<Integer> rootRightRight = BinaryTree.insertNode(rootRight, false, 6);
//		BinaryTree.inOrder(rootNonBST);
//		System.out.println();
//		System.out.println(BinaryTree.isBST(rootNonBST)); //Non BST
//		System.out.println(BinaryTree.isBST(root)); //BST
//		System.out.println("*******************************************");		
//		printLevelOrder(root);
//		System.out.println();
		
		List<Integer> list2 = new ArrayList<Integer>() {{
			add(5);
			add(3);
			add(2);
			add(4);
			add(1);
			add(7);
			add(6);
			add(8);
			add(9);
		}}; 
		Node<Integer> newTree = BinaryTree.buildBST(list2);
//		printLevelOrder(newTree);
//		System.out.println();
//		printlevelOrderInReverse(newTree);
		zigZag(newTree);
	}
	
	public static void inOrder(Node<Integer> root) {
		if(root == null) {
			return;
		}
		inOrder(root.getLeft());
		System.out.print(root.getValue() + SPACE);
		inOrder(root.getRight());
	}
	
	public static void preOrder(Node<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.getValue() + SPACE);
		preOrder(root.getLeft());		
		preOrder(root.getRight());
	}

	public static void postOrder(Node<Integer> root) {
		if(root == null) {
			return;
		}
		postOrder(root.getLeft());		
		postOrder(root.getRight());
		System.out.print(root.getValue() + SPACE);
	}
	
	public static int maxdepth(Node<Integer> root) {
		if(root == null) {
			return -1;			
		}
		return 1 + Math.max(maxdepth(root.getLeft()), maxdepth(root.getRight()));
	}
	
	public static int mindepth(Node<Integer> root) {
		if(root == null) {
			return -1;			
		}
		return 1 + Math.min(maxdepth(root.getLeft()), maxdepth(root.getRight()));
	}
	
	public static Node<Integer> insertNode(Node<Integer> node, boolean isToleft, int value) {

		if(node != null) {
			Node<Integer> newNode = new Node<Integer>(value, null, null);
			if(isToleft) {
				node.setLeft(newNode);				
			}
			else {
				node.setRight(newNode);
			}
			return newNode;
		}
		return null;
	}
	
	
	/***
	 * Given a BT, check if it is a BST or NOT.
	 * Input - Tree root.
	 * outPut boolean true if BST, false otherwise.
	 */
	
	public static boolean isBST(Node<Integer> root) {
		if(root == null) {
			return false;
		}
		if(root.getLeft() == null && root.getRight() == null) {
			return true;
		}
		boolean isLeftTreeBST = true;
		boolean isRightTreeBST = true;
		if(root.getLeft() != null) {
			isLeftTreeBST = isBST(root.getLeft()) && root.getValue() > root.getLeft().getValue();
		}
		if(root.getRight() != null) {
			isRightTreeBST = isBST(root.getRight()) && root.getValue() < root.getRight().getValue();
		}
		
		return isRightTreeBST && isLeftTreeBST;
	}
	
	public static void printLevelOrder(Node<Integer> root) {
		Queue<Node<Integer>> queue = new ArrayBlockingQueue<Node<Integer>>(100);
		if(root != null) {
			queue.add(root);
			while(!queue.isEmpty()) {
				Node<Integer> temp = queue.remove();
				System.out.print(temp.getValue() + SPACE);
				if(temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null) {
					queue.add(temp.getRight());
				}
			}			
		}		
	}
	
	public static void printlevelOrderInReverse(Node<Integer> root) {
		Queue<Node<Integer>> queue = new ArrayBlockingQueue<Node<Integer>>(100);
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		if(root != null) {
			queue.add(root);
			while(!queue.isEmpty()) {
				Node<Integer> temp = queue.remove();
				stack.push(temp);
				if(temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null) {
					queue.add(temp.getRight());
				}
			}
			
			while(!stack.isEmpty()) {
				System.out.print(stack.pop().getValue() + SPACE);
			}
		}
	}
	
	public static void zigZag(Node<Integer> root){
		
		if(root == null) {
			return;
		}
		
		Stack<Node<Integer>> currentStack = new Stack<Node<Integer>>(); 
		Stack<Node<Integer>> otherStack = new Stack<Node<Integer>>(); 
		boolean leftToRightFlag = true;
		
	    currentStack.add(root);
	    
		while(!currentStack.isEmpty()) {			
			while(!currentStack.isEmpty()) {
				Node<Integer> temp = currentStack.pop();
				System.out.print(temp.getValue() + SPACE);
				if(leftToRightFlag) {					
					if(temp.getRight() != null) {
						otherStack.push(temp.getRight());
					}
					if(temp.getLeft() != null) {
						otherStack.push(temp.getLeft());
					}
				}
				else {					
					if(temp.getLeft() != null) {
						otherStack.push(temp.getLeft());
					}
					if(temp.getRight() != null) {
						otherStack.push(temp.getRight());
					}
				}
			}
			System.out.println();
			leftToRightFlag = ! (leftToRightFlag);
			currentStack.addAll(otherStack);
			otherStack.clear();
		}		
	}	
}
