package ArrayAndMatrix;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CalculateMinSumTest {
    @Test
    public void review() throws Exception {
        Random random = new Random();
        for (int time = 0; time < 100; time++) {
            int[] arr = new int[random.nextInt(20) + 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(20);
            }
            int res1 = CalculateMinSum.calculateMinSum(arr);
            int res2 = CalculateMinSum.review(arr);
            assertEquals(res1, res2);
        }
    }

    @Test
    public void calculateMinSum() throws Exception {
        int[] arr = new int[]{1, 3, 5, 2, 4, 6};
        int expected = 27;
        int actual = CalculateMinSum.calculateMinSum(arr);
        assertEquals(expected, actual);
    }

}