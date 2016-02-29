package stackandqueues;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BracketsMatching {
	public static void main(String[] args) {
		String s = "{}(){}[]()";
		Solution sl = new Solution();
		System.out.println(sl.isBalanced(s));
	}
	
	private static class Solution {
		private static Set<Character> open = Collections.unmodifiableSet(new HashSet<Character>(Arrays.asList('(','{', '[')));
		private static Set<Character> close = Collections.unmodifiableSet(new HashSet<Character>(Arrays.asList(')','}', ']')));
		public boolean isBalanced(String br){
			Stack<Character> s = new Stack<>();
			for(Character c: br.toCharArray()) {
				if(open.contains(c)){
					s.push(c);
				}else if(close.contains(c)){
					Character ch = s.pop();
					if(ch == '[' && c != ']' ||  
							ch == '(' && c != ')' || 
							ch == '{' && c != '}'){
						return false;
						
					}
				}
			}
			return s.isEmpty();
			
		}
	}

}
