

public class TreeExamples {
	public static void main(String[] args) {
		int[] array = {7,6,5,4,3,2,1,8,9,10,11,12,13};
		TreeNode root = null;
		for(int i: array) {
			root = Tree.addNode(root, i);
		}
	}
}
