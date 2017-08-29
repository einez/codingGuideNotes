package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopKInNSortedArrayTest {
    @Test
    public void getTopKInNSortedArray() throws Exception {
        int[][] arr = new int[3][];
        arr[0] = new int[]{219, 405, 538, 845, 971};
        arr[1] = new int[]{148, 558};
        arr[2] = new int[]{52, 99, 348, 691};
        int k = 5;
        int[] expected = {538, 558, 691, 845, 971};
        int[] actual = TopKInNSortedArray.getTopKInNSortedArray(arr, k);
        assertArrayEquals(expected, actual);
    }

}