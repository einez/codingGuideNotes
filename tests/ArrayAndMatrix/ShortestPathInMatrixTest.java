package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestPathInMatrixTest {
    @Test
    public void getShortestPathInMatrix() throws Exception {
        int[][] matrix = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int expected = 12;
        int actual = ShortestPathInMatrix.getShortestPathInMatrix(matrix);
        assertEquals(expected, actual);
    }

}