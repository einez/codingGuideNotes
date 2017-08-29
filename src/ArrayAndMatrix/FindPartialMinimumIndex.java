package ArrayAndMatrix;

public class FindPartialMinimumIndex {
    public static int findPartialMinimumIndex(int[] arr) {
        if (arr.length < 1)
            return -1;
        if (arr.length == 1 || arr[0] < arr[1])
            return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2])
            return arr.length - 1;
        int start = 0, end = arr.length - 1, mid = start + (end - start) / 2;
        while (start < end) {
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1])
                return mid;
            else if (arr[mid] > arr[mid - 1]) {
                end = mid;
            } else {
                start = mid;
            }
            mid = start + (end - start) / 2;
        }
        return start;
    }
}
