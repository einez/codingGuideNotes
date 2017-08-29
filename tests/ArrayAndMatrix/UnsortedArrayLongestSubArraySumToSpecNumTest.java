package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnsortedArrayLongestSubArraySumToSpecNumTest {
    @Test
    public void testMethods() throws Exception {
        int[] arr = new int[]{0, 1, -1, 1, 1, 0, -1, -1};
        int expected = 8;
        int actual = UnsortedArrayLongestSubArraySumToSpecNum.posEqNeg(arr);
        assertEquals(expected, actual);
    }

}