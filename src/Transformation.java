import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Transformation {
	
	
	public static void main(String args[]) {
		System.out.println(transForm("TOP", "RAP"));
	}
	
	public static List<String> transForm(String start, String end){
		if(start.equals(end)){
			return Collections.singletonList(start);
		}		
		for(int j = 0; j < start.length(); j++) {
			int charAt = j;
			for(char i = 'A'; i < 'Z'; i++ ) {
				if(i == start.charAt(charAt)) {
					continue;
				}
				
				String temp = "";
				if(charAt == start.length() - 1) {
					temp = start.substring(0, charAt) + String.valueOf(i);
				}else {
					temp = start.substring(0, charAt) + String.valueOf(i) + start.substring(charAt + 1, start.length());
				}
				
				if(isWord(temp)) {				
					List<String> previous = transForm(temp, end);				
					if(!previous.isEmpty()) {					
						previous.add(temp);
						return previous;
					}
				}
				
			}
		}
		
		return Collections.emptyList();
	}
	
	public static boolean isWord(String word) {
		List<String> words = Arrays.asList("TOP", "TAP", "CAP", "COP","CAR","RAP","COT","LOT","HOT","POT","TAR");
		return words.contains(word);
	}

}
