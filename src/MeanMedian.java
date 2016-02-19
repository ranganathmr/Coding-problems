import java.util.Arrays;
import java.util.Random;

class MeanMedian {
	public static void main(String[] args) {
		test();
	}
	
	private static void test() {
		int n = 10;
		int trials = 6;
		IMath math = new MathImpl(1000);
		Random r = new Random();
		int[] testArray = new int[trials];
		for(int i = 0; i< trials; i++){
			int value= r.nextInt(n);
			testArray[i] = value;
			math.insert(value);
		}
		Arrays.sort(testArray);
		System.out.println();
		System.out.println(Arrays.toString(testArray));
		System.out.println("Mean: " + math.getMean());
		System.out.println("Median: " + math.getMedian());
	}

	private static interface IMath {
		
		public double getMean();

		public double getMedian();

		public void insert(int value);
		
	}

	private static class MathImpl implements IMath {
		private int countElements;

		private int sum;

		private int[] storage;

		public MathImpl(int n) {

			storage = new int[n];
			for (int i = 0; i < n; i++){
				storage[i] = 0;
			}
			countElements = 0;
			sum = 0;
		}

		@Override
		public double getMean() {
			return (double) sum / countElements;

		}

		@Override
		public double getMedian() {

			double median = -1;
			if(countElements % 2 == 1) {
				median = ithElement(countElements / 2);
			} else {
				int left = ithElement(countElements / 2);
				int right = ithElement((countElements / 2) - 1);
				median = (double)(left + right)/2;
			}
			return median;
		}
		
		private int ithElement(int i) {
			int sum = 0;
			i = i + 1;
			for( int in = 0; in < storage.length; in++ ){
				sum += storage[in];
				if(sum >= i){
					return in;
				}
			}
			return -1;
		}

		@Override
		public void insert(int i) {
			sum += i;
			countElements++;
			storage[i]++;
		}
	}

}