
public class ArrayProblems {
	
	public static void main(String[] args){
		subArrayMaxSum();
	}
	
	/***
	 * 1. Keep moving, if the totalSum of the bump is positive
	 * 2. Note the beginning of the positive bump. (minIndex)
	 * 3. Note the max point (maxBumpSum) of the positive bump. (maxPoint)
	 * 5. Return the bump with maximum (maxbumpSum).
	 */
	private static void subArrayMaxSum() {

		int gMinIndex = -1, gMaxIndex = -1, maxGlobalSum = Integer.MIN_VALUE;
		int maxBumpSum = 0;
		int totalBumpSum = 0, localMinIndex = -1, localMaxIndex = -1;
		
		int a[] = {1, 2, 7, 8, -5, 8, -9, 10, 11, 12, -400, 6};
		//int a[] = {1, 2, 7, 8, -5, -9, 14};
		
		
		for(int i = 0 ;i < a.length; i++) {
			
			if(totalBumpSum + a[i] > 0) {
				//  This satisfies point 1. (positive Bump)
				if(totalBumpSum == 0) {
					// this satisfies point 2.
					localMinIndex = i;
				}
				if(totalBumpSum + a[i] > maxBumpSum) {
					// (point 3)
					localMaxIndex = i;
					maxBumpSum = totalBumpSum + a[i];
				}
				totalBumpSum = totalBumpSum + a[i];
			}
			else if(totalBumpSum + a[i] <= 0) {
				//Just the context switch. Store the max Bump sum.
				if(maxBumpSum > maxGlobalSum) {
					maxGlobalSum = maxBumpSum;
					gMaxIndex = localMaxIndex;
					gMinIndex = localMinIndex;
				}
				totalBumpSum = 0;
				maxBumpSum = 0;
			}
		}
		// required for array with all positive elements
		if(maxBumpSum > maxGlobalSum) {
			maxGlobalSum = maxBumpSum;
			gMaxIndex = localMaxIndex;
			gMinIndex = localMinIndex;
		}
		
		System.out.println("Max Point(SUM) = " + maxGlobalSum);
		System.out.print("[");
		for(int i = 0 ;i < a.length; i++) {
			if( i >= gMinIndex && i <= gMaxIndex) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.print("]");
	}
	
}
