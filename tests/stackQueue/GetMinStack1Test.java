package stackQueue;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class GetMinStack1Test {

    GetMinStack1<Integer> getMinStack1;

    @Before
    public void init() {
        getMinStack1 = new GetMinStack1<>();
    }

    @Test
    public void pop() throws Exception {
        try {
            getMinStack1.pop();
        } catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
    }

    @Test
    public void push() throws Exception {
        for (int i = 0; i < 10; i++) {
            assertTrue(getMinStack1.push(i).equals(i));
        }
    }

    @Test
    public void getMin() throws Exception {
        for (int i = 9; i >= 0; i--) {
            getMinStack1.push(i);
            assertTrue(getMinStack1.getMin().equals(i));
        }
    }

}