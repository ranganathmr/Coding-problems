package arrays;
import java.util.Arrays;

public class MatrixRotationInMatrix {
	public static void main(String[] args) {
		
		int[][] matrix = {{01,02,03,04}, 
				          {05,06,07,8}, 
				          {9,10,11,12}, 
				          {13,14,15,16}};
		rotateMatrix(matrix, false, 1);
		printMatrix(matrix);
		rotateMatrix(matrix, true, 2);
		printMatrix(matrix);
	}
	
	public static void rotateMatrix(int[][] matrix, boolean rotateLeft, int rotateTimes) {
		if(matrix == null) {
			return;
		}
		for(int i = 0; i < rotateTimes; i++) {
			int length = matrix.length;
			int row = 0; // Start Row
			int col = 0; // Start Col
			while(length > 0) {
				for(int k = 0; k < length - 1; k++) {
					int temp = matrix[row][col + k];
					if(!rotateLeft) { // Rotate Right
						matrix[row][col + k] = matrix[row + length - 1 - k][col];
						matrix[row + length - 1 - k][col] = matrix[row + length - 1][col + length - 1 - k];
						matrix[row + length - 1][col + length - 1 - k] = matrix[row + k][col + length - 1];
						matrix[row + k][col + length - 1] = temp;
					} else {
						matrix[row][col + k] = matrix[row + k][col + length - 1];
						matrix[row + k][col + length - 1] = matrix[row + length - 1][col + length - 1 - k];
						matrix[row + length - 1][col + length - 1 - k] = matrix[row + length - 1 - k][col];
						matrix[row + length - 1 - k][col] = temp;
					}
				}
				length = length - 2;
				row++;
				col++;
			}
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		if(matrix == null) {
			return;
		}
		for(int i = 0; i < matrix.length; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
