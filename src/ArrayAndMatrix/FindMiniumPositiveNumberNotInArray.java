package ArrayAndMatrix;

import java.util.Arrays;

import static ArrayAndMatrix.CommonContract.swap;

public class FindMiniumPositiveNumberNotInArray {
    public static int findMiniumPositiveNumberNotInArray(int[] origin) {
        int[] arr = Arrays.copyOf(origin, origin.length);
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0 && arr[i] <= arr.length && arr[arr[i] - 1] != arr[i])
                swap(arr, i, arr[i] - 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1)
                return i + 1;
        }
        return arr.length + 1;
    }

    public static int toCompare(int[] origin) {
        int[] arr = Arrays.copyOf(origin, origin.length);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1)
                return i + 1;
        }
        return arr.length + 1;
    }
}
