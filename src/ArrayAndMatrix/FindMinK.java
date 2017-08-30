package ArrayAndMatrix;

import java.util.Arrays;

import static ArrayAndMatrix.CommonContract.swap;

public class FindMinK {
    public static int[] sortToCompare(int[] arr, int k) {
        if (k > arr.length || k < 1)
            return new int[]{};
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
        if (k > arr.length || k < 1)
            return new int[]{};
        if (k >= arr.length)
            return Arrays.copyOf(arr, arr.length);
        tickOutMinK(arr, 0, arr.length, k);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        Arrays.sort(ret, 0, ret.length);
        return ret;
    }

    //end is exclusive
    private static void tickOutMinK(int[] arr, int start, int end, int k) {
        if (k >= end - start + 1)
            return;
        int mid = getMidNum(arr, start, end);
        int right = partitionArray(arr, start, end, mid);
        int left = right;
        while (left > start && arr[left] == arr[left - 1])
            left--;
        if (right - start >= k - 1 && left - start <= k - 1)
            return;
        else if (right - start < k - 1) {
            tickOutMinK(arr, right + 1, end, k - 1 - right + start);
        } else {
            tickOutMinK(arr, start, left, k);
        }
    }

    //end is exclusive
    private static int partitionArray(int[] arr, int start, int end, int mid) {
        int i = start - 1, j = start, w = end;
        while (j < w) {
            if (arr[j] < mid) {
                i++;
                swap(arr, i, j);
            } else if (arr[j] == mid) {
                w--;
                swap(arr, j, w);
            }
            j++;
        }
        while (w < end) {
            swap(arr, ++i, w++);
        }
        return i;
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
}
