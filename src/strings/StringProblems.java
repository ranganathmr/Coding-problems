package strings;

public class StringProblems {
	
	public static void main(String[] args) {
		StrReverse();
		removeStringDuplicateChars();
	}
	
	public static void StrReverse() {
		char[] array = {'a','b','c','d','e','f','g','h','i','j'};
		
		print(array);
		
		int i = array.length - 1;
		int j = 0;
		while (j < (array.length /2)) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i--;
			j++;			
		}
		print(array);
	}
	
	public static void print(char[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(String.valueOf(array[i]));
		}
		System.out.println();
	}
	
	public static void removeStringDuplicateChars() {
		char array[] = {'a','f','d','e','r','f','g','h','d','j','d'};
		
		int tail = 1;
		
		for (int i = 1; i < array.length; i++) {
			int j = 0;
			for( j = 0; j < tail; j++) {
				if(array[i] == array[j]) {
					break;
				}
			}
			if(j == tail) {
				array[tail] = array[i];
				tail++;
			}			
		}
		
		for(int i = 0; i < tail; i++) {
			System.out.print(String.valueOf(array[i]));
		}
		System.out.println();
	}
}
