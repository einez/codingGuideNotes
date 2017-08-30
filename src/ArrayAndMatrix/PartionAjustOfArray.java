package ArrayAndMatrix;

import static ArrayAndMatrix.CommonContract.swap;

public class PartionAjustOfArray {
    public static int[] partionAjustOfArray(int[] arr) {
        int i = 0, j = 1;
        while (i < (arr.length - 1) / 2) {
            if (arr[j] <= arr[i]) {
                j++;
            } else {
                i++;
                swap(arr, i, j);
            }
        }
        int[] res = new int[(arr.length + 1) / 2];
        for (int k = 0; k < res.length; k++) {
            res[k] = arr[k];
        }
        return res;
    }
}
