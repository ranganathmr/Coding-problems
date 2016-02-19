
public class LongestOneStreak {
	
	public static void main(String[] args) {
		int[] a = {1,1,0,0,1,1,1,0,1,1};
		System.out.println(longestSequence(a, 3));
	}
	
	public static int longestSequence(int [] array, int k){
    	int maxLength = 0;
    	int start = 0;
    	int runningLength = 0;
    	int tmpK = k;
    	
    	for(int i = 0; i < array.length; i++){
    		if(array[i] == 1){
    			runningLength++;
    		}
    		else if(tmpK > 0 && tmpK < k){
    			tmpK--;
    			runningLength++;
    		}
    		else if(tmpK == k){
    			tmpK--;
    			runningLength++;
    		}
    		else{ //tmpK == 0
    			tmpK = k;
    			maxLength = Math.max(maxLength, runningLength);
    			runningLength = 0;
    		}
    	}
    	
    	return Math.max(maxLength, runningLength);
    }

}
