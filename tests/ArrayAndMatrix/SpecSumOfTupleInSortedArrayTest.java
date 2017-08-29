package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpecSumOfTupleInSortedArrayTest {
    @Test
    public void getTuple() throws Exception {
        int[] arr = new int[]{-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        int k = 10;
        String expected = "#1,9#2,8";
        assertEquals(expected, SpecSumOfTupleInSortedArray.getTuple(arr, k));
    }

    @Test
    public void getTriad() throws Exception {
        int[] arr = new int[]{-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        int k = 10;
        String expected = "#-4,5,9#-3,4,9#-3,5,8#0,1,9#0,2,8#1,4,5";
        assertEquals(expected, SpecSumOfTupleInSortedArray.getTriad(arr, k));
    }

}