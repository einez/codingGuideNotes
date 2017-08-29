package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProductOfSubArrayTest {
    @Test
    public void maxProductOfSubArray() throws Exception {
//        double[] arr = new double[]{-2.5, 4, 0, 3, 0.5, 8, -1};
//        double expected = 12;
        double[] arr = new double[]{0.1,0.1,100};
        double expected = 100;
        double actual = MaxProductOfSubArray.maxProductOfSubArray(arr);
        assertEquals(expected, actual, 0.0001);
    }

}