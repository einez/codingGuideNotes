package ArrayAndMatrix;

import java.util.Arrays;

public class FindNKNum {
    public static int findNKNum1(int[] arr, int k) {
        Arrays.sort(arr);
        for (int i = k; i < arr.length; i += k) {
            if (arr[i] == arr[i - k])
                return arr[i];
        }
        int cand = arr[arr.length - 1];
        for (int i = arr.length - k; i > 0 && i < arr.length; i++) {
            if (arr[i] != arr[i - 1])
                return -1;
        }
        return arr[arr.length - 1];
    }
}
