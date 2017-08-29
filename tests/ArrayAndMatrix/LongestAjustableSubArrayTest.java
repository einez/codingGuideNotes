package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestAjustableSubArrayTest {
    @Test
    public void getSubArray() throws Exception {
        int[] arr = new int[]{5, 5, 3, 2, 6, 4, 3};
        int[] expected = new int[]{5, 3, 2, 6, 4};
        assertArrayEquals(expected, LongestAjustableSubArray.getSubArray(arr));
    }

}