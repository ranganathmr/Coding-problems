package dynamicprogramming;

import java.util.Arrays;

public class LCSubsequence {
	
	public static void main(String[] args) {
		char[] a1 = {'a','b','c','a','d'};
		char[] a2 = {'a','c','e','a', 'd'};
		// Answer = acd
		System.out.println(lcSubSequence(a1, a2));
	}
	
	public static int lcSubSequence(char[] a1, char[] a2){
		int lcs = Integer.MIN_VALUE;
		
		//Init.
		int[][]mat = new int[a2.length + 1][a1.length+1];
		for(int i = 0; i < a1.length; i++){
			mat[0][i] = 0;
		}
		for(int i = 0; i < a2.length; i++) {
			mat[i][0] = 0;
		}
		
		for(int i = 1; i <=	a2.length; i++) {
			for(int j = 1; j <= a1.length; j++) {
				if(a1[j - 1] == a2[i - 1]) {
					mat[i][j] = 1 + mat[i-1][j-1];
				}else {
					mat[i][j] = mat[i-1][j] > mat[i][j-1] ? mat[i-1][j] : mat[i][j-1]; 
				}
				lcs = mat[i][j] > lcs ? mat[i][j] : lcs;
			}
		}
		
		for(int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		
		return lcs;
	}
	
}
