

public class ArrayModulo {
	
	public static void main(String[] args) {
		//speedoMeter();
		//sorting();
		wordCount();
	}
	
	public static void speedoMeter() {
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		
		int n = 4;
		int noOfIterations = 1;
		for(int i = 0; i < n; i++){
			noOfIterations *= array.length;
		}
		
		int[] counter = new int[n];
		
		for(int i = 0; i < n; i++){			
			counter[i] = 0;
		}
		
		for(int i = 0; i < noOfIterations; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < n; j++) {
				if(counter[j] == array.length){
					counter[j] = 0;
					counter[j+1]++;
				}
				sb.insert(0,array[counter[j]]);
				if(j == 0) {
					counter[j]++;
				}
			}
			System.out.println(sb.toString());			
		}
	}
	
	public static void sorting() {
		int[] array = {4,3,6,7,2,12,3,45,23,13,-1};
		
		for( int i = array.length - 2; i >=0; i--) {
			for(int j = 0; j <= i; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					System.out.println("swapped " + array[j+1] + " " + array[j]);
				}
			}
		}
		
		for( int i = 0; i < array.length; i++) {		
			System.out.println(array[i] + " ");
		}
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


