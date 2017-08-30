package ArrayAndMatrix;

import java.util.Arrays;

import static ArrayAndMatrix.CommonContract.swap;

public class FindMinK2 {
    public static int[] findMinK2(int[] arr, int k) {
        if (k > arr.length || k < 1)
            return new int[]{};
        int kth = getKthNum(arr, 0, arr.length, k);
        partitionArray(arr, 0, arr.length, kth);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        Arrays.sort(res);
        return res;
    }

    private static int getKthNum(int[] arr, int start, int end, int k) {
        if ((end - start) <= 6) {
            Arrays.sort(arr, start, end);
            return arr[start + k - 1];
        }
        int g = (end - start) / 5;
        if ((end - start) % 5 != 0)
            g++;
        int[] middles = new int[g];
        for (int i = 0; i < g - 1; i++) {
            Arrays.sort(arr, start + i * 5, start + i * 5 + 5);
            middles[i] = arr[start + i * 5 + 2];
        }
        Arrays.sort(arr, start + 5 * (g - 1), end);
        middles[g - 1] = arr[(start + 5 * (g - 1) + end - 1) / 2];
        int mid = getKthNum(middles, 0, middles.length, (middles.length + 1) / 2);
        int right = partitionArray(arr, start, end, mid);
        int left = right;
        while (left > start && arr[left] == arr[left - 1])
            left--;
        if (right - start >= k - 1 && left - start <= k - 1) {
            return arr[right];
        } else if (right - start < k - 1) {
            return getKthNum(arr, right + 1, end, k - right - 1 + start);//Take care of boundary, how start, end, k varies.
        } else return getKthNum(arr, start, left, k);
    }

    private static int partitionArray(int[] arr, int start, int end, int kth) {//Figure out the expected performance, numbers equals to kth should concentrate in the middle area.
        int i = start - 1, j = start, w = end;
        while (j < w) {
            if (arr[j] < kth) {
                i++;
                swap(arr, i, j);
            } else if (arr[j] == kth) {
                w--;
                swap(arr, j, w);
                continue;
            }
            j++;
        }
        while (w < end) {
            swap(arr, ++i, w++);
        }
        return i;
    }
}
