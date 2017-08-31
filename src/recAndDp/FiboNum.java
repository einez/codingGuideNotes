package recAndDp;

import java.util.Arrays;

public class FiboNum {
    public static int getN(int n) {
        if (n < 2)
            return 1;
        int i = 1, j = 1, k = 2;
        for (int l = 3; l <= n; l++) {
            k = i + j;
            i = j;
            j = k;
        }
        return k;
    }

    public static int getNInLgN(int n) {
        int[][] matrix = new int[][]{{1, 1}, {1, 0}};
        if (n < 2)
            return 1;
        int[] base = new int[]{1, 1};
        int[][] product = getPow(matrix, n - 2);
        return base[0] * product[0][0] + base[1] * product[1][0];
    }

    private static int[][] getPow(int[][] matrix, int pow) {
        if (pow == 0) {
            return new int[][]{{1, 0}, {0, 1}};
        } else if (pow == 1)
            return Arrays.copyOf(matrix, matrix.length);
        else {
            int[][] mid = getPow(matrix, pow / 2);
            mid = multiplyMatrix(mid, mid);
            if (pow % 2 == 1)
                mid = multiplyMatrix(mid, matrix);
            return mid;
        }
    }

    private static int[][] multiplyMatrix(int[][] m1, int[][] m2) {
        int[][] m3 = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < m1[0].length; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                m3[i][j] = sum;
            }
        }
        return m3;
    }
}
