package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestSumOfSubMatrixTest {
    @Test
    public void getLargestSumOfSubMatrix() throws Exception {
        int[][] matrix = new int[][]{{-90, 48, 78}, {64, -40, 64}, {-81, -7, 66}};
        int expected = 209;
        int actual = LargestSumOfSubMatrix.getLargestSumOfSubMatrix(matrix);
        assertEquals(expected, actual);
    }

}