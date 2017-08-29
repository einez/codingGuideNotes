package ArrayAndMatrix;

import java.util.Arrays;

public class CalculateMinSum {
    public static int calculateMinSum(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        return merge(copy, 0, (copy.length - 1) / 2, copy.length - 1);
    }

    private static int merge(int[] copy, int start, int mid, int end) {
        if (start == mid && mid == end) {
            return 0;
        }
        int count = merge(copy, start, start + (mid - start) / 2, mid) + merge(copy, mid + 1, mid + 1 + (end - mid - 1) / 2, end);
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, c = 0, sumi = 0;
        while (c < tmp.length) {
            if (j > end || i <= mid && copy[i] <= copy[j]) {
                sumi += copy[i];
                tmp[c++] = copy[i];
                i++;
            } else {
                count += sumi;
                tmp[c++] = copy[j];
                j++;
            }
        }
        i = start;
        c = 0;
        while (c < tmp.length)
            copy[i++] = tmp[c++];
        return count;
    }
}
