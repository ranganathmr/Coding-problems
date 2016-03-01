package searchsort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		sorting();
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
		
		System.out.println(Arrays.toString(array));
	}


}
