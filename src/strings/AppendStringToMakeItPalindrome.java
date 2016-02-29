package strings;

public class AppendStringToMakeItPalindrome {
	
	public static void main(String[] args) {
		System.out.println(makeItPalindrome("LLaLL"));
	}
	
	public static String makeItPalindrome(String s) {
		if(s == null || s.isEmpty()) {
			return s;
		}
		if(isPalindrome(s)) {
			return s;
		}
		String longestP = null;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(isPalindrome(s.substring(i, s.length()))) {
				longestP = s.substring(i, s.length());
			}
		}
		
		StringBuffer b = new StringBuffer(s);
		b.append(reverse(s.substring(0, s.length() - longestP.length())));
		return b.toString();
	}
	
	private static boolean isPalindrome(String s){
		boolean isP = true;
		
		if(s.length() == 1){
			return true;
		}
		
		for(int i = 0; i < s.length()/2; i++ ) {
			if(s.charAt(i) != s.charAt(s.length() - 1 -i)) {
				isP = false;
				break;
			}
		}
		return isP;
	}
	
	private static String reverse(String s){
		char[] a = new char[s.length()];
		for(int i = 0; i < s.length()/2; i++ ) {
			a[i] = s.charAt(s.length() - 1 -i);
			a[s.length() - 1 -i] = s.charAt(i);
		}
		return String.valueOf(a);
	}

}


