package trees;


public class Tree {
	
	public static TreeNode addNode(TreeNode node, int data){
		if(node == null) {
			return new TreeNode(data);
		}
		if(data < node.getData()) {
			node.setLeft(addNode(node.getLeft(), data));
		} else {
			node.setRight(addNode(node.getRight(), data));
		}
		return node;
	}
	
	private static int totalNodesInATreeAtLevel(int level) {
		int nodes = 0;
		while(level > -1) {
			nodes += (int) Math.pow(2, level--); 
		}
		return nodes;
	}
	
	public static int findTreelevel(TreeNode node) {
		if(node == null) {
			return -1;
		}
		if(node.getLeft() == null && node.getRight() == null) {
			return 0;
		}
		int leftLevel = 0;
		if(node.getLeft() != null) {
			leftLevel = findTreelevel(node.getLeft());
		}
		int rightLevel = 0;
		if(node.getRight() != null) {
			rightLevel = findTreelevel(node.getRight());
		}
		return Math.max(leftLevel, rightLevel) + 1;
	}
}
