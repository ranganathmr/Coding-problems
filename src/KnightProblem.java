
public class KnightProblem {
	
	public static void main(String[] args) {
		
		int[][] a = new int[12][12];
		
		
		for( int i = 0; i < 12; i++) {
			for( int  j = 0; j < 12; j++) {
				a[i][j] = 0;
			}
		}
		
		for(int i = 0; i < 12; i++) {
			a[i][0] = a[i][1] = a[i][10] = a[i][11] = 1;
			a[0][i] = a[1][i] = a[10][i] = a[11][i] = 1;			
		}
		
		printMatrix(a, 12, 12);
		
	}	
	
	
	public static void printMatrix(int[][] a, int row, int col) {
		for(int i = 0 ; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}		
	}
	
	public static int sum(int[][] a, int row, int col) {
		int sum = 0;
		for(int i = 0 ; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sum += a[i][j];
			}			
		}
		return sum;
	}
 }
