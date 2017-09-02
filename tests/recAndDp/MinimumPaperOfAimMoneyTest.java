package recAndDp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumPaperOfAimMoneyTest {
    @Test
    public void getMinimumPaperOfAimMoney() throws Exception {
        int[] arr1 = new int[]{5, 2, 3};
        int aim1 = 20;
        int expected1 = 4;
//        int actual1 = MinimumPaperOfAimMoney.getMinimumPaperOfAimMoney(arr1, aim1);
        int actual1 = MinimumPaperOfAimMoney.compressed(arr1, aim1);
        assertEquals(expected1, actual1);
    }

}