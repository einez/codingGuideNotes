package recAndDp;

public class Hanoi {
    public static void hanoi(int n) {
        move(n, "A", "B", "C");
    }

    private static void move(int n, String from, String mid, String to) {
        if (n == 0)
            return;
        else if (n == 1) {
            System.out.println(from + " -> " + to);
        } else {
            move(n - 1, from, to, mid);
            move(1, from, mid, to);
            move(n - 1, mid, from, to);
        }
    }

    public static int getStateSeq(int[] arr) {
        return process(arr, arr.length - 1, 1, 2, 3);
    }

    private static int process(int[] arr, int n, int from, int mid, int to) {
        if (n == -1)
            return 0;
        if (arr[n] == mid) {
            return -1;
        } else if (arr[n] == from) {
            return process(arr, n - 1, from, mid, to);
        } else {
            int tmp = process(arr, n - 1, mid, from, to);
            if (tmp == -1)
                return -1;
            else return 1 << n + tmp;
        }
    }
}
