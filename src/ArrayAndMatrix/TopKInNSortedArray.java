package ArrayAndMatrix;


import static ArrayAndMatrix.CommonContract.swap;

public class TopKInNSortedArray {

    public static int[] getTopKInNSortedArray(int[][] arrs, int k) {
        int[] maxK = new int[k];
        int n = arrs.length;
        int[] heap = new int[n + 1];
        int[] ni = new int[n];
        for (int i = 0; i < ni.length; i++) {
            ni[i] = arrs[i].length - 1;
        }
        for (int i = 1; i < heap.length; i++) {
            heap[i] = i - 1;
        }
        createHeap(heap, arrs, ni);
        while (k > 0) {
            int arrayNum = heap[1];
            maxK[--k] = arrs[arrayNum][ni[arrayNum]];
            ni[arrayNum]--;
            siftDown(heap, 1, heap.length - 1, arrs, ni);
        }
        return maxK;
    }

    private static void createHeap(int[] heap, int[][] arrs, int[] ni) {
        int heapSize = heap.length - 1;
        for (int i = heapSize / 2; i >= 1; i--) {
            siftDown(heap, i, heapSize, arrs, ni);
        }
    }

    private static void siftDown(int[] heap, int root, int heapSize, int[][] arrs, int[] ni) {
        while (root <= heapSize / 2) {
            int c = root * 2;
            if (root * 2 + 1 <= heapSize && getValue(arrs, ni, heap[root * 2 + 1]) > getValue(arrs, ni, heap[root * 2]))
                c = root * 2 + 1;
            if (getValue(arrs, ni, heap[root]) > getValue(arrs, ni, heap[c]))
                return;
            swap(heap, root, c);
            root = c;
        }
    }

    private static int getValue(int[][] arrs, int[] ni, int arrayNum) {
        if (ni[arrayNum] < 0)
            return Integer.MIN_VALUE;
        return arrs[arrayNum][ni[arrayNum]];
    }
}
