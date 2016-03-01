package dynamicprogramming;

import java.util.Arrays;

public final class DPUtil {
	
	private DPUtil(){}
	
	public static void printMatrix(int[][] mat){
		if(mat == null) {
			return;
		}
		for(int i = 0 ; i < mat.length; i++){
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	
	public static void printMatrix(char[][] mat){
		if(mat == null) {
			return;
		}
		for(int i = 0 ; i < mat.length; i++){
			System.out.println(Arrays.toString(mat[i]));
		}
	}

	public static void printMatrix(long[][] mat){
		if(mat == null) {
			return;
		}
		for(int i = 0 ; i < mat.length; i++){
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	
	public static void printMatrix(double[][] mat){
		if(mat == null) {
			return;
		}
		for(int i = 0 ; i < mat.length; i++){
			System.out.println(Arrays.toString(mat[i]));
		}
	}

	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

}
