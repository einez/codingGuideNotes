package recAndDp;


public class MinimumPathOfMatrix {
    public static int getMinimumPathOfMatrix(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1)
            return -1;
        int[][] helper = new int[matrix.length][matrix[0].length];
        helper[0][0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            helper[0][i] = helper[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            helper[i][0] = helper[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                helper[i][j] = Math.min(helper[i - 1][j], helper[i][j - 1]) + matrix[i][j];
            }
        }
//        for (int i = 0; i < helper.length; i++) {
//            System.out.println(Arrays.toString(helper[i]));
//        }
        return helper[helper.length - 1][helper[0].length - 1];
    }

    public static int compressed(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1)
            return -1;
        int[] helper = new int[matrix.length];
        helper[0] = matrix[0][0];
        for (int row = 1; row < helper.length; row++) {
            helper[row] = matrix[row][0] + helper[row - 1];
        }
        for (int col = 1; col < matrix[0].length; col++) {
            helper[0] += matrix[0][col];
            for (int row = 1; row < matrix.length; row++) {
                helper[row] = Math.min(helper[row], helper[row - 1]) + matrix[row][col];
            }
        }
        return helper[helper.length - 1];
    }
}
