
public class LongestStreakOnes {

	public static void main(String[] args) {
		int[] A = {0,0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0};
		System.out.println(compute(A, 1));
	}
	
	public static int compute(int[] A, int m){
		int wL = 0; int wR = 0; 
		int nZero = 0;
		int bestWindowWidth = -1;
		int bestWR, bestWL = -1;

		while(wR < A.length){	
			//expand to the right, update '0' count:
			if (nZero <= m){
				if (A[wR] == '0') nZero++;
				wR++;
			};

			//shrink from left, update '0' count:
			if (nZero > m){ 
				if (A[wL] == '0') nZero--;
				wL++;
			};
			
			//update best window:
			if (wR - wL > bestWindowWidth){
				bestWindowWidth = wR - wL;
				bestWR = wR;
				bestWL = wL;
			}	
		}
		return bestWindowWidth;
	}
}
