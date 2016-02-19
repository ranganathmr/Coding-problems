public class NumberClosestPalindrome {

	public static void main(String[] args) {
		int number = 1010;
		if (isPalindrome(number)) {
			System.out.println(number);
		} else {

			int digits = digits(number);

			int numberToAddOrSub = (int) Math.pow(10, digits / 2);
			for (int i = 0; i < numberToAddOrSub; i++) {

				if (number + i <= Integer.MAX_VALUE && isPalindrome(number + i)) {
					System.out.println(number + i);
					break;
				}
				if (isPalindrome(number - i)) {
					System.out.println(number - i);
					break;
				}
			}
		}

	}

	private static int digits(int number) {
		int digits = 0;
		while (number > 0) {
			number = number / 10;
			digits++;
		}
		return digits;
	}

	private static boolean isPalindrome(int number) {
		String s = String.valueOf(number);
		int strLength = s.length() - 1;
		int i = 0;
		while (i < s.length() / 2) {
			if (s.charAt(i) != s.charAt(strLength)) {
				return false;
			} else {
				i++;
				strLength--;
			}
		}
		return true;
	}
}
