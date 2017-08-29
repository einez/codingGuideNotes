package ArrayAndMatrix;

public class MaxProductOfSubArray {
    public static double maxProductOfSubArray(double[] arr) {
        double min = arr[0], max = arr[0], ret = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], Math.max(arr[i] * min, arr[i] * max));
            min = Math.min(arr[i], Math.min(arr[i] * min, arr[i] * max));
            ret = Math.max(ret, max);
        }
        return ret;
    }
}
