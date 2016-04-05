package searchsort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		int array[] = {4,3,6,7,2,12,3,45,23,13,-1};
		sorting(array);
	}
	
	public static void sorting(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int element = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > element){
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = element;
		}
		System.out.println(Arrays.toString(array));
	}
}
