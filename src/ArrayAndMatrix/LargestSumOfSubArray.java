package ArrayAndMatrix;

public class LargestSumOfSubArray {
    public static int getLargestSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int tillNow = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (tillNow > 0)
                tillNow += arr[i];
            else tillNow = arr[i];
            max = Math.max(max, tillNow);
        }
        return max;
    }
}
