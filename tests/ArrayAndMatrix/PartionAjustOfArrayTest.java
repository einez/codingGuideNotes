package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PartionAjustOfArrayTest {
    @Test
    public void partionAjustOfArray() throws Exception {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] actual = PartionAjustOfArray.partionAjustOfArray(arr);
        assertArrayEquals(expected, actual);
    }

}