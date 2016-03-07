package trees;

/**
 * Width of a tree.
 * 
 * @author rmysoreradhakrishna
 *
 */
public class WidthOfTree {

	public static void main(String[] args) {
		int[] numbers = {1,5,3,4,2,14,13,12,11,15,16};
		TreeNode root = null;
		for(int i: numbers) {
			root = Tree.addNode(root, i);
		}
		System.out.println(widthOfTree(root));
	}
	
	public static int widthOfTree(TreeNode root){
		Pair pair = width(root, 0);
		if(pair == null) {
			return 0;
		}
		return Math.abs(pair.min) + Math.abs(pair.max) + 1; // 1 more for '0'
	}
	
	private static Pair width(TreeNode root, int n) {
		if(root == null) {
			return null;
		}
		Pair resultPair = new Pair(n,n);
		if(root.getLeft() != null) {
			Pair left = width(root.getLeft(), n-1);
			resultPair = resultPair.getBiggerPair(left);
		}
		if(root.getRight() != null) {
			Pair right = width(root.getRight(), n+1);
			resultPair = resultPair.getBiggerPair(right);
		}
		return resultPair;
		
	}
	
	private static class Pair {
		int min;
		int max;
		
		public Pair(int min, int max){
			this.min = min;
			this.max = max;
		}
		
		public Pair getBiggerPair(Pair p){
			if(p == null) {
				return this;
			}
			return new Pair((this.min < p.min ? this.min : p.min),
							(this.max > p.max ? this.max : p.max));
		}
	}
}
