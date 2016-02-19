public class TwosCompliment {
	
	public static void main(String[] args) {
		TwoC c = new TwoC();
		System.out.println(c.twosCompliment("001"));
	}
	
	private static class TwoC {
		
		public String twosCompliment(String str) {
			if(str == null || str.isEmpty()){
				return str;
			}
			char[] invertedArr = invert(str).toCharArray();
			for(int i = invertedArr.length - 1; i >= 0; i--) {
				Result result = add(invertedArr[i], '1');
				invertedArr[i] = result.result();
				if(!result.isCarry()) {
					break;
				}
			}
			return new String(invertedArr);
		}
		
		private static String invert(String str) {
			if(str == null) {
				throw new RuntimeException("Test String cannot be empty");
			}
			char[] strArray  = str.toCharArray();
			for(int i = 0; i < str.length(); i++) {
				if(strArray[i] == '1') {
					strArray[i] = '0';
				} else {
					strArray[i] = '1';
				}
			}
			return new String(strArray);
		}

		private Result add(char one, char two) {
			if(one == '1' && two == '1') {
				return new Result(true, '0');
			} else if((one == '1' && two == '0') || (one == '0' && two =='1')) {
				return new Result(false, '1');
			} else {
				return new Result(false, '0');
			}
		}
	}
	
	private static class Result {
		private boolean isCarry;
		private char result;
		
		Result(boolean isCarry, char result) {
			this.isCarry = isCarry;
			this.result = result;
					
		}
		public boolean isCarry() {
			return isCarry;
		}
		
		public char result() {
			return result;
		}
	}
}
