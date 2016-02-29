package strings;

public class WordCount {
	
	public static void main(String[] args) {
		wordCount();
	}
	
	public static void wordCount() {
		String at = "This is  a Test      and better know   it.";
		char[] a = at.toCharArray();
		boolean isSpaceAlreadySeen = false;
		int count = 0;
		for(int i = 0; i < a.length; i++) {			
			if(a[i] ==' '){
				if(isSpaceAlreadySeen){
					continue;
				}else {
					count++;
					isSpaceAlreadySeen = true;
				}
			} else {
				isSpaceAlreadySeen = false;
			}
		}
		System.out.println(count);
	}
}


