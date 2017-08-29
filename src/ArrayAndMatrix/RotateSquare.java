package ArrayAndMatrix;

import java.util.Arrays;

public class RotateSquare {
    public static int[][] rotateSquare(int[][] origin) {
        if (origin.length < 1)
            return new int[][]{};
        int[][] arr = Arrays.copyOf(origin, origin.length);
        for (int i = 0; i < (1 + arr.length) / 2; i++) {
            for (int j = 0; j < (1 + arr[0].length) / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[arr.length - 1 - j][i];
                arr[arr.length - 1 - j][i] = arr[arr.length - 1 - i][arr.length - 1 - j];
                arr[arr.length - 1 - i][arr.length - 1 - j] = arr[j][arr.length - 1 - i];
                arr[j][arr.length - 1 - i] = tmp;
            }
        }
        return arr;
    }

    public static int[][] toCompare(int[][] origin) {
        if (origin.length < 1)
            return new int[][]{};
        int[][] matrix = Arrays.copyOf(origin, origin.length);
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
        return matrix;
    }

    private static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }
}
