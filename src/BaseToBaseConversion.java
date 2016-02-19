
public class BaseToBaseConversion {
	
	public static void main(String[] args) {
		BaseN two = new BaseN(6);
		System.out.println(two.toBaseN(7));
	}
	
	private static class BaseN {
		
		private int base;
		
		public BaseN(int number) {
			if(number < 2) {
				throw new RuntimeException("Should be greater than 2");
			}
			this.base = number;
		}
		
		public String toBaseN(int decimal) {
			StringBuffer buf = new StringBuffer();
			while(decimal >= base) {
				int rem = decimal % base;
				buf.insert(0, String.valueOf(rem));
				decimal /= base;
				
			}
			// last piece
			if(decimal <= base) {
				buf.insert(0, String.valueOf(decimal));
			}
			return buf.toString();
			
		}
	}
}
