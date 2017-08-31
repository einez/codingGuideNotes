package ArrayAndMatrix;

import java.util.Arrays;

public class UnsortedArrayLongestSubArraySumLessThanSpecNum {
    public static int getLongestLen(int[] arr, int sum) {
        int[] helper = new int[arr.length];
        helper[0] = 0;
        int pSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            helper[i] = Math.max(helper[i - 1], pSum);
            pSum += arr[i];
        }
        int maxLen = 0;
        pSum = 0;
        for (int i = 0; i < arr.length; i++) {
            pSum += arr[i];
            int e = Arrays.binarySearch(helper, pSum - sum);
            if (e < 0) {
                e = -e - 1;
            } else while (e > 0 && helper[e - 1] == pSum - sum)
                e--;
            maxLen = Math.max(maxLen, i - e + 1);
        }
        return maxLen;
    }

    public static int review(int[] arr, int sum) {
        int[] curSum = new int[arr.length];
        int[] curMax = new int[arr.length];
        curSum[0] = arr[0];
        curMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curSum[i] = curSum[i - 1] + arr[i];
            curMax[i] = curSum[i] > curMax[i - 1] ? curSum[i] : curMax[i - 1];
        }
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = Arrays.binarySearch(curMax, curSum[i] - sum);
            while (index > 0 && curSum[index] == curSum[index - 1]) {
                index--;
            }
            if (index < 0)
                index = -(index + 1);
            maxLen = Math.max(maxLen, i - index);
        }
        return maxLen;
    }
}
