package ArrayAndMatrix;

import java.util.Arrays;

public class FindMinK {
    public static int[] sortToCompare(int[] arr, int k) {
        if (k >= arr.length)
            return Arrays.copyOf(arr, arr.length);
        int[] ret = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    public static int[] getMinK(int[] arr, int k) {
        if (k >= arr.length)
            return Arrays.copyOf(arr, arr.length);
        tickOutMinK(arr, 0, arr.length, k);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        Arrays.sort(ret,0,ret.length);
        return ret;
    }

    //end is exclusive
    private static void tickOutMinK(int[] arr, int start, int end, int k) {
        if (k >= end - start)
            return;
        int mid = getMidNum(arr, start, end);
        int midIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] == mid) {
                midIndex = i;
                break;
            }
        }
        int seq = partionArray(arr, start, end, midIndex);
        if (seq == k - 1)
            return;
        else if (seq < k - 1) {
            tickOutMinK(arr, seq + 1, end, k - 1 - seq);
        } else {
            tickOutMinK(arr, start, seq, k);
        }
    }

    //end is exclusive
    private static int partionArray(int[] arr, int start, int end, int midIndex) {
        int pivot = arr[midIndex];
        swap(arr, midIndex, end - 1);
        int f = -1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                f++;
                swap(arr, f, i);
            }
        }
        return f;
    }

    //end is exclusive
    private static int getMidNum(int[] arr, int start, int end) {
        int g = (end - start) / 5;
        if (g <= 1) {
            Arrays.sort(arr, start, end);
            return arr[start + (end - start) / 2];
        }
        int r = g * 5 + start;
        if (r < end) {
            Arrays.sort(arr, r, end);
            g++;
        }
        for (int i = start; i + 5 < r; i += 5) {
            Arrays.sort(arr, i, i + 5);
        }
        int[] midArr = new int[g];
        for (int i = 0; i < g - 1; i++) {
            midArr[i] = arr[i * 5 + 2];
        }
        if (r < end)
            midArr[g - 1] = arr[r + (end - r) / 2];
        else midArr[g - 1] = arr[end - 3];
        return getMidNum(midArr, 0, g);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
