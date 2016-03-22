package dynamicprogramming;

public class LongestIncreasingSequence {
	
	public static void main(String[] args) {
		int[] seq = {1,2,4,8,5,6,3};
		System.out.println(longestIncreasingSequence(seq));
	}
	
	public static int longestIncreasingSequence(int[] a) {
		if(a == null) {
			return -1;
		}
		int[] count = new int[a.length];
		for(int i = 0; i < count.length; i++) {
			count[i] = 1;
		}
		int longestSequence = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < i; j++){
				if(a[j] < a[i]) {
					if(count[j] + 1 > count[i]) {
						count[i] = count[j] + 1;
						longestSequence = (count[i] > longestSequence) ? count[i] : longestSequence;
					}
				}
			}
		}
		DPUtil.printArray(count);
		return longestSequence;
	}

}
