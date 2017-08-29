package ArrayAndMatrix;

public class UnsortedPositeiveArrayLongestSubArraySumToSpecNum {
    public static int getLongestLength(int[] arr, int sum) {
        int i = 0, j = 0, maxLen = 0, pSum = 0;
        while (j < arr.length) {
            pSum += arr[j];
            if (pSum > sum) {
                pSum -= arr[i];
                i++;
            } else if (pSum == sum) {
                maxLen = Math.max(maxLen, j - i + 1);
                pSum -= arr[i];
                i++;
            }
            j++;
        }
        return maxLen;
    }
}
