package recAndDp;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LongestAsscendingSubSequenceTest {
    @Test
    public void getLongestAsscendingSubSequence() throws Exception {
//        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
//        int[] expected = new int[]{1, 3, 4, 8, 9};
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] expected = new int[]{1};
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 1, 2, 2, 1};
        int[] expected = new int[]{1, 2};
//        int[] actual = LongestAsscendingSubSequence.getLongestAsscendingSubSequence(arr);
        int[] actual = LongestAsscendingSubSequence.optimized(arr);
        assertArrayEquals(expected, actual);
    }

}