
public class MinimalSwap {

	public static void main(String[] args) {
		//int[] a = { 1, 1, 2, 3, 3, 4, 2, 5, 6, 7, 7, 5, 8, 8 };
		int[] a = { 1, 1, 2, 3, 2, 4, 4};
		System.out.println(solve(a));

	}

	private static int solve(int[] a) {
		int swaps = 0;
		int i = 0;
		while( i < a.length - 1) {
			if(a[i] != a[i + 1]) {
				int secondLetterPosition = findLetterPosition(a[i], a, i+1);
				if(secondLetterPosition  != -1 ) {
					int min = solve(swap(a, i+1, secondLetterPosition));
					int minOneMore = solve(swap(a, i-1, secondLetterPosition));
					min = min < minOneMore ? min : minOneMore;
					int minAnother = solve(swap(a, i, secondLetterPosition + 1));
					min = min < minAnother ? min : minAnother;
					int minYetAnother =  solve(swap(a, i, secondLetterPosition - 1));
					min = min < minYetAnother ? min : minYetAnother;
					swaps = swaps + 1 + min;
				}
				
			}
			i = i + 2;
		}
		
		return swaps;
	}

	private static int findLetterPosition(int searchElement, int[] a,
			int startPosition) {
		for (int i = startPosition; i < a.length; i++) {
			if (a[i] == searchElement) {
				return i;
			}
		}
		return -1;
	}
	
	private static int[] swap(int[] a, int i, int j) {
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
		return a;
	}

}
