package stackQueue;

/**
 * Created by einez on 8/8/2017.
 */
public class BuildMaxTreeOfArray {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node[] buildHeap(int[] arr) {
        int[] helper = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            helper[i + 1] = arr[i];
        }
        for (int i = arr.length / 2; i >= 1; i--) {
            siftUp(helper, arr.length, i);
        }
        Node[] nodes = new Node[helper.length];
        for (int i = 1; i < helper.length; i++) {
            nodes[i] = new Node(helper[i]);
        }
        for (int i = arr.length / 2; i >= 1; i--) {
            nodes[i].left = nodes[2 * i];
            if (2 * i + 1 <= arr.length)
                nodes[i].right = nodes[2 * i + 1];
        }
        return nodes;
    }

    private static void siftUp(int[] heap, int heapSize, int p) {
        int child;
        while (2 * p <= heapSize) {
            child = 2 * p;
            if (2 * p + 1 <= heapSize && heap[2 * p + 1] > heap[child])
                child = 2 * p + 1;
            if (heap[child] < heap[p])
                break;
            swap(heap, p, child);
            p = child;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
