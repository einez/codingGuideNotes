package ArrayAndMatrix;

import static ArrayAndMatrix.CommonContract.swap;

public class SortOneToN {
    public static void sortOneToN(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                swap(arr,i,arr[i]-1);
            }
        }
    }
}
