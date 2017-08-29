package stackQueue;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class GetMinStack2Test {


    GetMinStack2<Integer> getMinStack2;

    @Before
    public void init() {
        getMinStack2 = new GetMinStack2<>();
    }

    @Test
    public void pop() throws Exception {
        try {
            getMinStack2.pop();
        } catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
    }

    @Test
    public void push() throws Exception {
        for (int i = 0; i < 10; i++) {
            assertTrue(getMinStack2.push(i).equals(i));
        }
    }

    @Test
    public void getMin() throws Exception {
        for (int i = 9; i >= 0; i--) {
            getMinStack2.push(i);
            assertTrue(getMinStack2.getMin().equals(i));
        }
    }


}