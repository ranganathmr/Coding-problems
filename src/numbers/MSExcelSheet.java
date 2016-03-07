package numbers;

public class MSExcelSheet {

	public static void main(String[] args) {
	}
	
	public static int getNumber(String s){
		//26 = A
		if(s == null || s.isEmpty()) {
			return 0;
		}
		int val = 0;
		val += (int)(s.charAt(s.length() - 1) - 65);
		int power = 1;
		for(int i = s.length() - 2; i>= 0; i--){
			val += (int)(s.charAt(i) - 64) * Math.pow(26, power++);
		}
		return val;
	}
	
	public static String getColumn(int number)
	{
		String alphabet="";
		while( number > 0 )
		{
			int mod = number % 26;
			alphabet = Character.toString ((char) (mod + 65)) + alphabet;
			number = (number / 26) - 1;
		}
		if( number == 0 )
		{
			alphabet = "A" + alphabet;
		}
		return alphabet;
	}
}
