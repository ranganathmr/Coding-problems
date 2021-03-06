package searchsort;

public class RotatedArray {

	public static void main(String[] args) {
		int[] a = {30, 35, 40, 50, 400, 20000, 30000, -5, -4, -3, -2, -1, 0, 1, 3, 4, 5, 6, 7};
		System.out.println(findPivotNumber(a, a.length - 1, 0));
	}
	
	private static int findPivotNumber(int[] a, int h, int l) {
		if(h - l > 1) {
			int m = l + (h-l)/2;
			if(a[l] > a[m]) {
				return findPivotNumber(a, m, l);
			} else {
				return findPivotNumber(a, h, m);
			}
		}
		return a[l] > a[h] ? a[l] : a[h];
	}
	
}