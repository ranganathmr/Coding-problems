package trees;

public class TreeNode {
	
	private int data;
	
	private TreeNode left;
	
	private TreeNode right;

	public TreeNode(int value) {
		this.data = value;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
}
