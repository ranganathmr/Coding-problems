package dynamicprogramming;

import java.util.Arrays;

public class SubsetSum {
	public static void main(String[] args) {
		int[] array = {-2, -3, 4, -1, -2, 1, 5, -3, 8, 7, -5, 4, 5, 8, -4};
		System.out.println(highestSubSetSum(array));
	}

	private static int highestSubSetSum(int[] array) {
		int[][] subsetSum = new int[array.length][array.length];

		// Prep
		for (int i = 0; i < subsetSum.length; i++) {
			for (int j = 0; j < subsetSum[0].length; j++) {
				if (i == j) {
					subsetSum[i][j] = array[i];
				} else {
					subsetSum[i][j] = 0;
				}
			}
		}
		
		// execute
		for(int length = 1; length <= array.length; length++){
			for(int i = 0; (i + length) < array.length; i++){
				int sumOfAll = sum(array,i, i + length);
				int left = subsetSum[i][i + length - 1];
				int bottom = subsetSum[i + 1][i + length];
				int sum = max(sumOfAll, left, bottom);
			    subsetSum[i][i + length] = sum;
			}
		}
		
		print(subsetSum);
		return subsetSum[0][array.length - 1];
	}

	private static void print(int[][] subsetSum) {
		for (int i = 0; i < subsetSum.length; i++) {
			System.out.println(Arrays.toString(subsetSum[i]));
		}
	}
	
	private static int sum(int[] array, int start, int end){
		int sum = 0;
		for(int i = start; i <= end; i++){
			sum += array[i];
		}
		return sum;
	}
	
	private static int max(int a, int b, int c){
		int temp = b > c ? b: c;
		return a > temp ? a: temp;
	}
}
