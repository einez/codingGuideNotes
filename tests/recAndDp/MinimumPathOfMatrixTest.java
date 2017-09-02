package recAndDp;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MinimumPathOfMatrixTest {
    @Test
    public void getMinimumPathOfMatrix() throws Exception {
        Random random = new Random();
        for (int time = 0; time < 100; time++) {
            int row = random.nextInt(20), col = random.nextInt(20);
            int[][] matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = random.nextInt(20) + 1;
                }
            }
//        int[][] matrix = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
            int expected = MinimumPathOfMatrix.getMinimumPathOfMatrix(matrix);
            int actual = MinimumPathOfMatrix.compressed(matrix);
            System.out.println("expected= " + expected + ", actual= " + actual);
            assertEquals(expected, actual);
        }
    }

}