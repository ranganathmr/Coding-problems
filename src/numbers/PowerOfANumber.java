package numbers;

public class PowerOfANumber {
	
	public static void main(String[] args) {
		System.out.println(isPowerof(27, 3));
		System.out.println(isPowerof(81, 3));
		System.out.println(isPowerof(16, 2));
		System.out.println(isPowerof(25, 3));
	}
	
	public static boolean isPowerof(int number, int n){
		while(number % n == 0) {
			number /= n;
		}
		return number == 1;
	}

}
