package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnsortedPositeiveArrayLongestSubArraySumToSpecNumTest {
    @Test
    public void getLongestLength() throws Exception {
        int[] arr = new int[]{1, 2, 1, 1, 1};
        int k = 3;
        int expected = 3;
        assertEquals(expected, UnsortedPositeiveArrayLongestSubArraySumToSpecNum.getLongestLength(arr, k));
    }

}