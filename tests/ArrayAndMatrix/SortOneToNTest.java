package ArrayAndMatrix;

import org.junit.Test;

import java.util.Random;

import static ArrayAndMatrix.CommonContract.swap;
import static org.junit.Assert.*;

public class SortOneToNTest {
    @Test
    public void sortOneToN() throws Exception {
        Random random = new Random();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                int x = random.nextInt(9);
                int y = random.nextInt(9);
                swap(arr, x, y);
            }
            SortOneToN.sortOneToN(arr);
            assertArrayEquals(expected, arr);
        }
    }

}