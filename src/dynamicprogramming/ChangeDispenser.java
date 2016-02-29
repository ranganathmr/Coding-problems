package dynamicprogramming;
import java.util.ArrayList;
import java.util.List;



public class ChangeDispenser
{	
	public static void main(String[] args){
		int[] coins = {8,2,5,12};
		int change = 12; 		
		System.out.println(ChangeDispenser.numCoins(coins, change));
		System.out.println("**************");
		System.out.println(ChangeDispenser.getAllCoinCombo(coins, 11));

	}
	
	public static int numCoins(int[] coins, int change){
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < coins.length; i++){
			if(coins[i] == change){
				return 1;
			}
			else if(change - coins[i] > 0) {
				int num = numCoins(coins, change - coins[i]);
				if(num < min) {
					min = num;
				}
				
			} else {
				return Integer.MAX_VALUE;
			}
		}
		return min + 1;
	}
	
	public static List<String> getAllCoinCombo(int coins[], int change) {
		List<String> combos = new ArrayList<String>();
		for( int i = 0; i < coins.length; i++) {
			if(coins[i] == change){
				combos.add(String.valueOf(coins[i]));
			}
			else {
				if(change - coins[i] > 0) {
					List<String> local = getAllCoinCombo(coins, change - coins[i]);
					if(local != null && !local.isEmpty()) {
						for(String s: local){
							combos.add(String.valueOf(coins[i]) + " " + s);
						}
					}
				}else {
					return null;
				}
			}
		}
		return combos;
	}
}
