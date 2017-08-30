package ArrayAndMatrix;

public class AccumulateProductWithoutSelf {
    public static int[] getAccumulateProductWithoutSelf(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        int factor = 1;
        for (int i = 1; i < result.length; i++) {
            factor *= arr[i - 1];
            result[i] *= factor;
        }
        factor = 1;
        for (int i = result.length - 2; i >= 0; i--) {
            factor *= arr[i + 1];
            result[i] *= factor;
        }
        return result;
    }
}
