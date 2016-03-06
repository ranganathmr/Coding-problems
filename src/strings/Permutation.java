package strings;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static void main(String[] args) {
		String s= "abc";
		System.out.println(permute(s, 3));
	}
	
	public static List<String> permute(String s, int len){
		if(s == null){
			return null;
		}
		if(len > s.length()) {
			len = s.length();
		}
		if(len == 1){
			List<String> list = new ArrayList<String>();
			for(int i = 0; i < s.length(); i++){
				list.add(String.valueOf(s.charAt(i)));
			}
			return list;
		}
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			List<String> list = permute(stringExceptCharAt(s, i),len - 1);
			for(String g: list){
				result.add(s.charAt(i) + g);
			}
		}
		return result;
	}
	
	private static String stringExceptCharAt(String s, int i){
		if( i >= s.length()){
			throw new RuntimeException("i is bigger than String s");
		}
		return s.substring(0, i) + s.substring(i +1, s.length());
	}

}
