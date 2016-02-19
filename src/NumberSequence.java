import java.util.HashSet;
import java.util.Set;

public class NumberSequence {
	
	public static void main(String[] args) {
		NumberSequence seq = new NumberSequence();
		int[] array = {19, -2, 1,4,7,10,13, 16};
		System.out.println(seq.verifySequence(array));
	}
	
	
	public boolean verifySequence(int[] array) {
		if(array == null) {
			return false;
		}
		if(array.length == 1 || array.length == 2) {
			return true;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			} 
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		int diff = (max - min)/(array.length - 1);
		Set<Integer> set = new HashSet<Integer>();
		for(Integer i: array) {
			set.add(i);
		}

		boolean result = true;
		for(int i = 0; i < array.length; i++) {
			result = result & set.contains( min + i* diff);
		}
		return result;
			
	}
}
