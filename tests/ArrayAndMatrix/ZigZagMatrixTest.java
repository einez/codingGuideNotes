package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagMatrixTest {
    @Test
    public void getZigZag() throws Exception {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        String expected = "1,2,5,9,6,3,4,7,10,11,8,12";
        assertEquals(expected, ZigZagMatrix.getZigZag(matrix));
    }

}