package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args) {
		char[] a = {'a','b','c'};
		System.out.println(subsets(a, 0));
	}
	
	public static List<String> subsets(char[] c, int startIndex){
		if(c == null) {
			return null;
		}
		if(startIndex == c.length) {
			return Collections.singletonList("");
		}
		
		List<String> intermediate = subsets(c, startIndex + 1);
		List<String> result = new ArrayList<String>();
		result.addAll(intermediate);
		for(String s: intermediate) {
			result.add(s + String.valueOf(c[startIndex]));
		}
		return result;
	}

}
