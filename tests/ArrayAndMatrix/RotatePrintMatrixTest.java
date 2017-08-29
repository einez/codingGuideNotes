package ArrayAndMatrix;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RotatePrintMatrixTest {
    @Test
    public void rotatePrint() throws Exception {
        int[][] arr = new int[4][4];
        int seed = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = seed++;
            }
        }
        String expected = "1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10";
        assertEquals(expected, RotatePrintMatrix.rotatePrint(arr));
        int[][] arr2 = new int[][]{{1}, {2}, {3}, {4}};
        String expected2 = "1,2,3,4";
        assertEquals(expected2, RotatePrintMatrix.rotatePrint(arr2));
    }

}