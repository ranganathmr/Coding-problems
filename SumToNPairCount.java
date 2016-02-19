
public class SumToNPairCount {
	public static void main(String[] args) {
		int[] a = {1, 2, 40};
		int N = 42;
		int sumPairs = 0;
		int index = 0;
		int i = a.length - 1;
		while( index < i) {
			if(a[i] + a[index] >= N) {
				sumPairs += (i - index);
				i--;
			} else {
				index++;
			}
		}
		System.out.println(sumPairs);
	}
}
