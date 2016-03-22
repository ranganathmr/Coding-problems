package numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComboWords {
	
	public static void main(String[] args) {
		String s = "112315";
		System.out.println(getCombos(s, 0));
	}
	
	
	private static boolean isWithinLimit(int num){
		return num > 0 && num < 27;
	}
	
	private static char getChar(int num) {
		return (char)(num + 64);
	}
	
	private static List<String> getCombos(String num, int index) {
		List<String> result = new ArrayList<String>();
		if(index >= num.length()) {
			return Collections.emptyList();
		}
		for(int i = 0; i < 2; i++) {
			if(index + i + 1 > num.length()) {
				continue;
			}
			String g = num.substring(index, index + i + 1);
			if(isWithinLimit(Integer.parseInt(g))){
				char c = getChar(Integer.valueOf(g));
				List<String> list = getCombos(num, index + i + 1);
				if(! list.isEmpty()) {
					for(String str: list){
						result.add(String.valueOf(c) + str);
					}
				}else {
					result.add(String.valueOf(c));
				}
			}
		}
		return result;
	}
}
