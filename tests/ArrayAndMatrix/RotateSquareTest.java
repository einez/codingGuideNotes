package ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class RotateSquareTest {
    @Test
    public void rotateSquare() throws Exception {
        Random random = new Random();
        for (int t = 0; t < 10; t++) {
            int n = random.nextInt(10);
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = random.nextInt(10);
                }
            }
            int[][] expected = RotateSquare.toCompare(arr);
            int[][] actual = RotateSquare.rotateSquare(arr);
            assertArrayEquals(expected, actual);
        }
    }

}