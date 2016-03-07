package trees;

/**
 * This one assumes there are no duplicates in the tree.
 * 
 * @author rmysoreradhakrishna
 *
 */
public class CommonAncestor {
	private static boolean v1 = false;
	private static boolean v2 = false;
	
	public static void main(String[] args) {
		int[] numbers = {15,7,20, 4, 10, 17, 23, 2, 5, 8, 11, 18, 22, 24, 1, 3, 6};
		TreeNode root = null;
		for(int i: numbers) {
			root = Tree.addNode(root, i);
		}
		TreeNode node = commonAncestor(root, 7, 8);
		if(node != null && v1 && v2) {
			System.out.println(node.getData());
		}else {
			System.out.println("Sorry");
		}
		
	}
	
	/** This method traverses full tree.
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static TreeNode commonAncestor(TreeNode root, int n1, int n2) {
		//Base case and end Recursion.
		if(root == null) {
			return null;
		}
		
		TreeNode left = commonAncestor(root.getLeft(), n1, n2);
		TreeNode right = commonAncestor(root.getRight(), n1, n2);
		
		if(left != null && right != null) {
			return root;
		}
		if(root.getData() == n1){
			v1 = true;
			return root;
		}
		if(root.getData() == n2){
			v2 = true;
			return root;
		}
		return left != null ? left : right;
	}

}
