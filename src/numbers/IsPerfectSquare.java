package numbers;

public class IsPerfectSquare {
	public static void main(String[] args) {
		System.out.println(isPerfectSquare(13, 0, 27));
	}

	public static boolean isPerfectSquare(int high, int low, int n) {
		if (n < 1) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		if (low < high) {
			int half = (high + low) / 2;
			int a = half * half;
			if (a == n) {
				return true;
			}
			if(a > n) {
				return isPerfectSquare(half - 1, low, n);
			} else {
				return isPerfectSquare(high, half + 1, n);
			}
		}
		return false;
	}
}
