package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaxMatrixBoundedWithOneTest {
    @Test
    public void maxMatrixBoundedWithOne() throws Exception {
        int[][] matrix = new int[][]{
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1}
        };
        int[] expected = new int[]{3, 4, 4};
        int[] actual = MaxMatrixBoundedWithOne.maxMatrixBoundedWithOne(matrix);
        assertArrayEquals(expected, actual);
    }

}