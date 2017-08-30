package ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MaxDiffOfNeighborAfterSortedTest {
    @Test
    public void getMaxDiffOfNeighborAfterSorted() throws Exception {
        Random random = new Random();
        for (int w = 0; w < 100; w++) {
            int size = random.nextInt(20);
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(30);
            }
            System.out.println(Arrays.toString(arr));
            int expected = MaxDiffOfNeighborAfterSorted.toCompare(arr);
            int actual = MaxDiffOfNeighborAfterSorted.getMaxDiffOfNeighborAfterSorted(arr);
            assertEquals(expected, actual);

        }
    }

}