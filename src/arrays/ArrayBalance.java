package arrays;

public class ArrayBalance {

	public static int balanceArray(int[] arr){
        int left = 0;
        int right = arr.length -1;
        int leftSum = 0;
        int rightSum = 0;

        while (right > left){

            if (rightSum >= leftSum){
                leftSum += arr[left];
                left++;
            } else {
                rightSum += arr[right];
                right--;
            }
        }
        return right;
    }

}
