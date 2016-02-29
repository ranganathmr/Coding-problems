package numbers;
import java.util.HashMap;
import java.util.Map;


public class NumberToWords {
	
	private static Map<Integer, String> numberToWords;
	private static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000, 1000000, 1000000000};
	
	public static void main(String[] args) {
		initMap();
		int number = 1578632044;
		
		if(number < 1 || number > 999999999 ){
			throw new IllegalArgumentException("Sorry");
		}
		breakDownNumber(number);
	}
	
	private static void breakDownNumber(int number){
		while(number > 0) {
			int i = 0;
			int div = 0;
			while(number > a[i]) {
				i++;
			}
			if(number != a[i]) {
				i--;
				div = number/a[i];
				if(a[i] > 90){
					breakDownNumber(div);
				}
				printWord(a[i]);
			} else {
				printWord(a[i]);
			}
			number = number % a[i];
		}
	}
	
	private static void printWord(int number) {
		System.out.print(numberToWords.get(number));
	}
	
	private static void initMap() {
		numberToWords = new HashMap<Integer, String>();
		numberToWords.put(1, "one ");
		numberToWords.put(2, "two ");
		numberToWords.put(3, "three ");
		numberToWords.put(4, "four ");
		numberToWords.put(5, "five ");
		numberToWords.put(6, "six ");
		numberToWords.put(7, "seven ");
		numberToWords.put(8, "eight ");
		numberToWords.put(9, "nine ");
		numberToWords.put(10, "ten ");
		numberToWords.put(11, "eleven ");
		numberToWords.put(12, "twelve ");
		numberToWords.put(13, "thirteen ");
		numberToWords.put(14, "fourteen ");
		numberToWords.put(15, "fifteen ");
		numberToWords.put(16, "sixteen ");
		numberToWords.put(17, "seventeen ");
		numberToWords.put(18, "eighteen ");
		numberToWords.put(19, "nineteen ");
		numberToWords.put(20, "twenty ");
		
		numberToWords.put(30, "thirty-");
		numberToWords.put(40, "forty-");
		numberToWords.put(50, "fifty-");
		numberToWords.put(60, "sixty-");
		numberToWords.put(70, "seventy-");
		numberToWords.put(80, "eighty-");
		numberToWords.put(90, "ninety-");
		
		numberToWords.put(100, "hundred ");
		numberToWords.put(1000, "thousand ");
		numberToWords.put(1000000, "million ");
	}
}
