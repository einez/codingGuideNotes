package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestSumOfSubArrayTest {
    @Test
    public void getLargestSum() throws Exception {
        int[] arr = new int[]{3, 5, -2, 6};
        int expected = 12;
        int actual = LargestSumOfSubArray.getLargestSum(arr);
        assertEquals(expected, actual);
    }

}