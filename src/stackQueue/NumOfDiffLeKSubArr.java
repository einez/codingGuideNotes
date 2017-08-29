package stackQueue;

import java.util.LinkedList;

/**
 * Created by einez on 8/8/2017.
 */
public class NumOfDiffLeKSubArr {
    public static int getNumOfDiffLeKSubArr(int[] arr, int K) {
        int ret = 0;
        LinkedList<Integer> maxQu = new LinkedList<>();
        LinkedList<Integer> minQu = new LinkedList<>();
        int head = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!maxQu.isEmpty() && arr[i] > arr[maxQu.peekLast()])
                maxQu.pollLast();
            maxQu.offerLast(i);
            while (!minQu.isEmpty() && arr[i] < arr[minQu.peekLast()])
                minQu.pollLast();
            minQu.offerLast(i);
            while (arr[maxQu.peekFirst()] - arr[minQu.peekFirst()] > K) {
                int lastToDiscard;
                if (maxQu.peekFirst() < minQu.peekFirst()) {
                    lastToDiscard = maxQu.peekFirst();
                    maxQu.pollFirst();
                } else {
                    lastToDiscard = minQu.peekFirst();
                    minQu.pollFirst();
                }
                for (int j = head; j <= lastToDiscard; j++) {
                    ret += i - j;
                }
                head = lastToDiscard + 1;
            }
        }
        for (int i = head; i < arr.length; i++) {
            ret += arr.length - i;
        }
        return ret;
    }

    public static int normalSolution(int[] arr, int K) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int max = arr[i], min = arr[i];
                for (int k = i; k <= j; k++) {
                    max = Math.max(max, arr[k]);
                    min = Math.min(min, arr[k]);
                }
                if (max - min <= K) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public static int solutionInBook(int[] arr, int num) {
        if (arr == null || arr.length == 0)
            return 0;
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0, j = 0, res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i)
                qmin.pollFirst();
            if (qmax.peekFirst() == i)
                qmax.pollFirst();
            res += j - i;
            i++;
        }
        return res;
    }
}
