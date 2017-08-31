package recAndDp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FiboNumTest {
    @Test
    public void getN() throws Exception {
        int expected = FiboNum.getN(300);
        int actual = FiboNum.getNInLgN(300);
        assertEquals(expected, actual);
    }

}