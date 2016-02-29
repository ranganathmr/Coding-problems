package trie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Trie {
	
	protected String data;
	
	protected Character character;
	
	protected Map<Character, Trie> children;
	
	public Trie(char c) {
		this.character = c;
		this.children = new HashMap<Character, Trie>();
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public void setChildren(Map<Character, Trie> children) {
		this.children = children;
	}
	
	public String getData() {
		return data;
	}

	public Character getCharacter() {
		return character;
	}

	public Map<Character, Trie> getChildren() {
		return children;
	}

	protected void addData(String str, int index){
		if(str == null) {
			return;
		}
		if(index == str.length() - 1) {
			this.character = str.charAt(index);
			this.data = str;
			return;
		}
		this.character = str.charAt(index);
		char c = str.charAt(index + 1);
		Trie child = children.get(c);
		if(child == null) {
			child = new Trie(c);
			this.children.put(c, child);
		}
		child.addData(str, index + 1);
	}
	
	public void addData(String str) {
		addData(str, 0);
	}
	
	public void print() {
		print(this);
	}
	
	protected void print(Trie t) {
		if(t != null) {
			if(t.getData() != null) {
				System.out.println(t.getCharacter() + " : " + t.getData());
			} else {
				System.out.println(t.getCharacter());
			}
			if(! t.getChildren().isEmpty()) {
				for(Trie child: t.getChildren().values()) {
					print(child);
				}
			}
		}
	}
	
	public List<String> search(String prefix) {
		return searchInternal(prefix, 0);
	}
	
	protected List<String> searchInternal(String prefix, int index){
		List<String> matches = new ArrayList<String>();
		if(index == prefix.length() - 1) {
			if(this.data != null && this.data.equals(prefix)) {
				matches.add(this.data);
			}
			for(Trie child: children.values()) {
				matches.addAll(child.getDataFromChildren());
			}
			return matches;
		} else {
			char i = prefix.charAt(index + 1);
			if(children.containsKey(i)) {
				return children.get(i).searchInternal(prefix, index + 1);
			}
		}
		return Collections.emptyList();
	}
	
	protected List<String> getDataFromChildren() {
		List<String> dataList = new ArrayList<String>();
		if( this.data != null ) {
			dataList.add(this.data);
		}
		for(Trie child: children.values()){
			dataList.addAll(child.getDataFromChildren());
		}
		return dataList;
	}
	
	
	
	public static class RootTrieNode extends Trie {
		
		public RootTrieNode() {
			super('#');
		}
		
		@Override
		protected void addData(String str, int index) {
			char c = str.charAt(index);
			Trie child = children.get(c);
			if(child == null) {
				child = new Trie(c);
				this.children.put(c, child);
			}
			child.addData(str, index);
		}
		
		@Override
		public List<String> search(String prefix) {
			if(children.containsKey(prefix.charAt(0))) {
				return children.get(prefix.charAt(0)).search(prefix);
			}
			return Collections.emptyList();
		}
	}
}
