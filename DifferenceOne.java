
public class DifferenceOne {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,3,2,1,0,-1,-2,-1};
		System.out.println(searchIndex(a, a.length - 1, 0, 4));
		//int[] a = {1,2,3,4,5,6,7,8};
	}
	
	private static int searchIndex(int[] a, int h, int l, int key){
		if(l <= h) {
			int m = (h-l)/2 + l;
			if(a[m] == key) {
				return m;
			} else{
				int bumpHigh = Math.abs(a[m] - key) + Math.abs(key - a[h]); 
				int bumpLow = Math.abs(a[m] - key) + Math.abs(key - a[l]);
				int roomHigh = h-m;
				int roomLow = m-l;
				int indexLow = -1;
				int indexHigh = -1;
				if(roomHigh >= bumpHigh) {
					indexHigh = searchIndex(a, h, m + 1, key);
				}
				if(roomLow >= bumpLow) {
					indexLow = searchIndex(a, m - 1, l, key);
				}
				return Math.max(indexHigh, indexLow);
			}
		} else {
			return -1;
		}
	}

}
