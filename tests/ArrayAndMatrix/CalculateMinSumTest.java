package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateMinSumTest {
    @Test
    public void calculateMinSum() throws Exception {
        int[] arr = new int[]{1, 3, 5, 2, 4, 6};
        int expected = 27;
        int actual = CalculateMinSum.calculateMinSum(arr);
        assertEquals(expected, actual);
    }

}