package ArrayAndMatrix;

import java.util.Arrays;

public class MaxDiffOfNeighborAfterSorted {
    public static int getMaxDiffOfNeighborAfterSorted(int[] arr) {
        if (arr.length < 2)
            return -1;
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int interval = (max - min) / (arr.length - 1);
        if ((max - min) % (arr.length - 1) > 0)
            interval++;
        if (interval == 0)
            return 0;
        int[][] buckets = new int[arr.length][2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < arr.length; i++) {
            int seq = (arr[i] - min) / interval;
            if (buckets[seq][0] > arr[i])
                buckets[seq][0] = arr[i];
            if (buckets[seq][1] < arr[i])
                buckets[seq][1] = arr[i];
        }
        int preBucket = 0, maxDiff = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i][0] != Integer.MAX_VALUE) {
                if (buckets[i][0] - buckets[preBucket][1] > maxDiff)
                    maxDiff = buckets[i][0] - buckets[preBucket][1];
                preBucket = i;
            }
        }
        return maxDiff;
    }

    public static int toCompare(int[] origin) {
        if (origin.length < 2)
            return -1;
        int[] arr = Arrays.copyOf(origin, origin.length);
        Arrays.sort(arr);
        int maxDiff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > maxDiff)
                maxDiff = arr[i] - arr[i - 1];
        }
        return maxDiff;
    }
}
