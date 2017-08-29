package stackQueue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class MaxSubMatrixTest {
    @Test
    public void getMaxSubMatrixSize() throws Exception {
        int[][] matrix = new int[][]{{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        assertTrue(6 == MaxSubMatrix.getMaxSubMatrixSize(matrix));
    }

}