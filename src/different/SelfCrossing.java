package different;

/**
 * You are given an array x of n positive numbers. You start at point (0,0) and
 * moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to
 * the south, x[3] metres to the east and so on. In other words, after each move
 * your direction changes counter-clockwise.
 * 
 * Write a one-pass algorithm with O(1) extra space to determine, if your path
 * crosses itself, or not.
 * 
 * https://leetcode.com/problems/self-crossing/
 * 
 * 
 * @author rmysoreradhakrishna
 *
 */
public class SelfCrossing {
	public static void main(String[] args) {
		//int[] a = {2,2,4,1,10};
		 int[] a = {3,3,3,2,2,1};
		  //int[] a = { 3,3,4,2,2 };
		System.out.println(isSelfCrossing(a));

	}

	public static boolean isSelfCrossing(int[] x) {
		if(x.length < 4) {
			return false;
		}
		
		boolean expanding = false;
		if(x[2] > x[0]) {
			expanding = true;  
		}
		
		for( int i = 3; i < x.length;i++ ) {
			// Two things
			// 1. act on previous decision (Expanding or not)
			// 2. If not intersecting, set the decision for future.
			
			// Step 1;
			if(x[i] >=  x[i-2]){
				if(! expanding){
					return true;
				}
			} else {
				//x[i] < x[i - 2]
				if(i == 4){ // 5th Line (Special case)
					if(x[4] + x[0] >= x[2] && x[3] == x[1]) {
						return true;
					}
				}
				if(i > 4) { // There are at least six lines. 
					if(!expanding 
							&& x[i] >= (x[i-2] - x[i-4]) && x[i-2] > x[i-4] 
							&& x[i- 1] >= (x[i-3] - x[i-5]) && x[i-3] > x[i-5]
							){
						return true;
					}
				}
				
			}
			
			// if this far, then not intersecting.
		    // set the decision.
			// Step 2;
			expanding = (x[i] > x[i-2]) ? true: false;
		}
		return false;
	}
}
