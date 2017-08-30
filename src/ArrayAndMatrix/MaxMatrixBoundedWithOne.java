package ArrayAndMatrix;

public class MaxMatrixBoundedWithOne {
    public static int[] maxMatrixBoundedWithOne(int[][] matrix) {
        int[][] rowHelper = new int[matrix.length][matrix[0].length];
        int[][] colHelper = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            rowHelper[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0)
                    rowHelper[i][j] = rowHelper[i][j - 1] + 1;
                else rowHelper[i][j] = 0;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            colHelper[0][i] = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] != 0)
                    colHelper[j][i] = colHelper[j - 1][i] + 1;
                else colHelper[j][i] = 0;
            }
        }
        int[] result = new int[]{0, 0, matrix[0][0]};
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                int side = Math.min(rowHelper[i][j], colHelper[i][j]);
                for (; side > result[2]; side--) {
                    if (rowHelper[i - side + 1][j] >= side && colHelper[i][j - side + 1] >= side) {
                        result[0] = i;
                        result[1] = j;
                        result[2] = side;
                    }
                }
            }
        }
        return result;
    }
}
