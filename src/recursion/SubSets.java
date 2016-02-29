package recursion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SubSets {
	
	public static void main(String args[]) {
		
		List<String> list = getSubSet("abcd");
		list.add("EMPTY");
		System.out.println(list);
		System.out.println(strCombination("rang", 4));
			
	}
	
	
	public static List<String> getSubSet(String str) {
		if(str.length() == 1) {
			return Collections.singletonList(str);
		}
		
		List<String> list = getSubSet(str.substring(1, str.length()));
		List<String> newList = new ArrayList<String>();
		newList.addAll(list);
		
		for(String s: list){
			newList.add(String.valueOf(str.charAt(0)) + s);
		}
		newList.add(String.valueOf(str.charAt(0)));
		return newList;
	}
	
	public static List<String> strCombination(String str, int n) {
		if(n == 1) {
			List<String> list = new ArrayList<String>();
			for(int i = 0; i < str.length(); i++){
				list.add(String.valueOf(str.charAt(i)));
			}
			return list;
		}
		List<String> strings = new ArrayList<String>();
		for(int i = 0; i < str.length(); i++) {
			String current  = String.valueOf(str.charAt(i));
			for(String s: strCombination(stringWithoutCharAt(str, i), n - 1)) {
				strings.add(current + s); 
			}
		}
		return strings;
	}
	
	public static String stringWithoutCharAt(String str, int i) {
		return str.substring(0, i) + str.substring(i + 1, str.length());		
	}
}
