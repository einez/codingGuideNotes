package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class AccumulateProductWithoutSelfTest {
    @Test
    public void getAccumulateProductWithoutSelf() throws Exception {
        int[] arr = new int[]{2, 3, 1, 4};
        int[] expected = new int[]{12, 8, 24, 6};
        int[] actual = AccumulateProductWithoutSelf.getAccumulateProductWithoutSelf(arr);
        assertArrayEquals(expected, actual);
    }

}