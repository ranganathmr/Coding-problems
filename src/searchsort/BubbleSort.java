package searchsort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		sorting();
	}
	
	public static void sorting() {
		int[] array = {4,3,6,7,2,12,3,45,23,13,-1};
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = 0; j < array.length - i - 1; j++){
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

}
