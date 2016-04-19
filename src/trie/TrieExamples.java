package trie;

public class TrieExamples {
	
	public static void main(String[] args) {
		Trie t = new Trie.RootTrieNode();
		t.addData("hello");
		t.addData("heaven");
		t.addData("high");
		t.addData("cricket");
		t.addData("crow");
		t.addData("crab");
		t.addData("hell");
		t.addData("crabed");
		t.addData("crying");
		t.addData("fly");
		t.addData("lion");
		t.addData("tiger");
		t.addData("elephant");
		t.addData("crocodile");
		System.out.println(t.search("crab"));
	}
}
