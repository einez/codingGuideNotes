package stackQueue;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class GenMaxArrOfWindowTest {
    @Test
    public void genMaxArrOfWindow() throws Exception {
        Integer[] origin = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int windowSize = 5;
        Integer[] ret = new Integer[origin.length - windowSize + 1];
        GenMaxArrOfWindow.genMaxArrOfWindow(origin, windowSize, ret);
        Integer[] expected = new Integer[]{5, 6, 7, 8, 9, 9};
        assertArrayEquals(expected, ret);
    }

}