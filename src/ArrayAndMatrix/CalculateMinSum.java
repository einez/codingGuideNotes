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

    public static int review(int[] origin) {
        int[] arr = Arrays.copyOf(origin, origin.length);
        return ms(arr, 0, arr.length - 1);
    }

    private static int ms(int[] arr, int start, int end) {
        if (end == start)
            return 0;
        int mid = start + (end - start) / 2;
        int sub = ms(arr, start, mid) + ms(arr, mid + 1, end);
        int[] a = new int[mid - start + 2];
        int[] b = new int[end - mid + 1];
        int[] c = new int[end - start + 1];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = arr[start + i];
        }
        a[a.length - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < b.length - 1; i++) {
            b[i] = arr[mid + 1 + i];
        }
        b[b.length - 1] = Integer.MAX_VALUE - 1;
        int x = 0, y = 0, z = 0, pSum = 0, mSum = 0;
        while (z < c.length) {
            if (a[x] <= b[y]) {
                pSum += a[x];
                c[z++] = a[x++];
            } else {
                mSum += pSum;
                c[z++] = b[y++];
            }
        }
        for (int i = 0; i < c.length; i++) {
            arr[start + i] = c[i];
        }
        return mSum + sub;
    }


}
