package recAndDp;

import java.util.Arrays;

public class LongestAsscendingSubSequence {
    //O(n^2)
    public static int[] getLongestAsscendingSubSequence(int[] arr) {
        int maxDp = 0;
        int[] dp = new int[arr.length];
        int[] path = new int[arr.length];
        dp[0] = 1;
        path[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            path[i] = i;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 >= dp[i]) {//递增而不是非递减；同等情况，优先选取后面的数
                    dp[i] = dp[j] + 1;
                    path[i] = j;
                }
            }
            if (dp[i] >= dp[maxDp]) {//同等情况，优先选取后面的数
                maxDp = i;
            }
        }
        int[] res = new int[dp[maxDp]];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = arr[maxDp];
            maxDp = path[maxDp];
        }
        return res;
    }

    //二分查找: O(n*lgn)
    public static int[] optimized(int[] arr) {
        //ends和endsIndex分别存储数值和索引，preIndex[i]代表索引为i的数前一个数的索引
        int[] ends = new int[arr.length];
        for (int i = 0; i < ends.length; i++) {
            ends[i] = Integer.MAX_VALUE;
        }
        ends[0] = arr[0];
        int[] endsIndex = new int[arr.length];
        endsIndex[0] = 0;
        int[] preIndex = new int[arr.length];
        preIndex[0] = 0;
        int pLen = 1;
        for (int i = 1; i < arr.length; i++) {
            int index = Arrays.binarySearch(ends, arr[i]);
            if (index < 0)
                index = -(index + 1);
            pLen = pLen > index ? pLen : pLen + 1;
            ends[index] = arr[i];//同等情况，优先选取后面的数
            endsIndex[index] = i;
            preIndex[i] = index > 0 ? endsIndex[index - 1] : i;
        }
        int[] res = new int[pLen];
        int p = endsIndex[pLen - 1];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = arr[p];
            p = preIndex[p];
        }
        return res;
    }

}
