package dynamicprogramming;

/**
 * You are allowed to go down and right.
 * Start at (0,0) and end up at (N, N)
 * collect as many apples as you can.
 * What's the maximum number of apples you can collect ?
 * 
 * @author rmysoreradhakrishna
 *
 */
public class CollectingApples {
	
	public static void main(String[] args) {
		int[][] a = {{4, 5},
				     {8, 9}};
		System.out.println(maxApples(a));
	}
	
	public static int maxApples(int[][] a) {
		if(a == null) {
			return -1;
		}
		int[][] apples = new int[a.length + 1][a[0].length + 1];
		for(int  i = 0;i < apples.length; i++){
			apples[i][0] = 0;
		}
		for(int i = 0; i < apples[0].length; i++) {
			apples[0][i] = 0;
		}
		
		for(int i = 1; i < apples.length; i++) {
			for(int j = 1; j < apples[0].length; j++){
				int maxApples = apples[i-1][j] > apples[i][j-1] ? apples[i-1][j] : apples[i][j-1];
				apples[i][j] = a[i-1][j-1] + maxApples;
			}
		}
		
		DPUtil.printMatrix(apples);
		return apples[apples.length - 1][apples[0].length -1];
	}
	
	

}
