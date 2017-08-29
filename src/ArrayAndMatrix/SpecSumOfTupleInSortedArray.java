package ArrayAndMatrix;

public class SpecSumOfTupleInSortedArray {
    public static String getTuple(int[] arr, int sum) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] < sum)
                i++;
            else if (arr[i] + arr[j] > sum) {
                j--;
            } else {
                if (i == 0 || arr[i] != arr[i - 1])
                    sb.append("#" + arr[i] + "," + arr[j]);
                i++;
                j--;
            }
        }
        return sb.toString();
    }

    public static String getTriad(int[] arr, int sum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 2; i++) {
            int x = i + 1, y = arr.length - 1;
            while (x < y) {
                if (arr[x] + arr[y] < sum - arr[i]) {
                    x++;
                } else if (arr[x] + arr[y] > sum - arr[i]) {
                    y--;
                } else {
                    if (x == i + 1 || arr[x] != arr[x - 1]) {
                        sb.append("#" + arr[i] + "," + arr[x] + "," + arr[y]);
                    }
                    x++;
                    y--;
                }
            }
        }
        return sb.toString();
    }
}
