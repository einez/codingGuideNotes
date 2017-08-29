package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindNKNumTest {
    @Test
    public void findNKNum() throws Exception {
        int[] arr = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 2};
        int k = 3;
        int expected = 2;
        int actual = FindNKNum.findNKNum1(arr, k);
        assertEquals(expected, actual);
    }

}