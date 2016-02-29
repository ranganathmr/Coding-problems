package numbers;

/**
 * Given the String "IDDI", you have to arrange
 * numbers such that the numbers Increase, Decrease, Decrease, Increase.
 * The numbers should be as small as possible
 * Example: IDDI = 34215 
 * (3 to 4 = I, 4 to 2 = D, 2 to 1 = D, 1 to 5 = I)
 *
 */
public class IncreaseDecrease {
	
	public static void main(String[] args) {
		System.out.println(sequence("IDDI"));
	}
	
	/**
	 * ID = 231
	 * D = 1, start with D + 1;
	 * countI = D + 1 + 1;
	 * @param sequence
	 * @return
	 */
	public static String sequence(String sequence) {
		StringBuffer b = new StringBuffer();
		int countD = countD(sequence) + 1;
		int countI = countD + 1;
		b.append(countD--);
		for(int i = 0; i < sequence.length(); i++){
			if(sequence.charAt(i) == 'D') {
				b.append(countD--);
			}else {
				b.append(countI++);
			}
		}
		return b.toString();
	}
	
	private static int countD(String sequence) {
		int countD = 0;
		for(int i = 0; i < sequence.length(); i++) {
			if(sequence.charAt(i) == 'D') {
				countD++;
			}
		}
		return countD;
	}
}
