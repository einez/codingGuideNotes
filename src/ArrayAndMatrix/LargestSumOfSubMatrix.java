package ArrayAndMatrix;

public class LargestSumOfSubMatrix {
    public static int getLargestSumOfSubMatrix(int[][] matrix) {
        int row = matrix[0].length, col = matrix.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = row - 1; j >= i; j--) {
                if (i != 0) {
                    for (int k = 0; k < col; k++) {
                        matrix[j][k] += matrix[j - i][k];
                    }
                }
                int tillNow = matrix[j][0];
                max = Math.max(max, tillNow);
                for (int k = 1; k < col; k++) {
                    if (tillNow > 0) {
                        tillNow += matrix[j][k];
                    } else tillNow = matrix[j][k];
                    max = Math.max(max, tillNow);
                }
            }
        }
        return max;
    }
}
