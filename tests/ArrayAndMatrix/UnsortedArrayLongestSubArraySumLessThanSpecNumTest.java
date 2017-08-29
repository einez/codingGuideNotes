package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnsortedArrayLongestSubArraySumLessThanSpecNumTest {
    @Test
    public void getLongestLen() throws Exception {
        int[] arr = new int[]{2,10, 3};
        int k = 2;
        int expected = 1;
        int actual = UnsortedArrayLongestSubArraySumLessThanSpecNum.getLongestLen(arr, k);
        assertEquals(expected, actual);
    }

}