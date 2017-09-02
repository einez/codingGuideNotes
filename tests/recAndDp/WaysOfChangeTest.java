package recAndDp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaysOfChangeTest {
    @Test
    public void getWaysOfChange() throws Exception {
        int[] bills = new int[]{5, 10, 25, 1};
        int aim = 0;
        int expected = 1;
        int actual = WaysOfChange.compressed(bills, aim);
//        int[] bills = new int[]{5, 10, 25, 1};
//        int aim = 15;
//        int expected = 6;
//        int actual = WaysOfChange.compressed(bills, aim);
//        int[] bills = new int[]{5, 10, 25, 1};
//        int aim = 2;
//        int expected = 0;
//        int actual = WaysOfChange.compressed(bills, aim);
        assertEquals(expected, actual);
    }

}