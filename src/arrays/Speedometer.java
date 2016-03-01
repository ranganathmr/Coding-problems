package arrays;

public class Speedometer {
	
	public static void main(String[] args) {
		speedoMeter();
	}
	
	public static void speedoMeter() {
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		
		int n = 4;
		int noOfIterations = 1;
		for(int i = 0; i < n; i++){
			noOfIterations *= array.length;
		}
		
		int[] counter = new int[n];
		
		for(int i = 0; i < n; i++){			
			counter[i] = 0;
		}
		
		for(int i = 0; i < noOfIterations; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < n; j++) {
				if(counter[j] == array.length){
					counter[j] = 0;
					counter[j+1]++;
				}
				sb.insert(0,array[counter[j]]);
				if(j == 0) {
					counter[j]++;
				}
			}
			System.out.println(sb.toString());			
		}
	}


}
