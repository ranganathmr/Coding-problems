import java.util.Map;

public class SuffixTree {
	public static void main(String[] args) {
		String word = "Banana";
		
	}
	
	private class Node {
		public Character label;
		public Map<Character, Node> children;
		public boolean isLeaf;
	}

}
