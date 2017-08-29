package stackQueue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class QueueOfTwoStackTest {
    QueueOfTwoStack<Integer> queueOfTwoStack;

    @Before
    public void init() {
        queueOfTwoStack = new QueueOfTwoStack<>();
    }

    @Test
    public void add() throws Exception {
        for (int i = 0; i < 10; i++) {
            assertTrue(queueOfTwoStack.add(i));
        }
    }

    @Test
    public void poll() throws Exception {
        for (int i = 0; i < 10; i++) {
            queueOfTwoStack.add(i);
            assertTrue(queueOfTwoStack.poll().equals(i));
            assertNull(queueOfTwoStack.poll());
        }
    }

    @Test
    public void peek() throws Exception {
        for (int i = 0; i < 10; i++) {
            queueOfTwoStack.add(i);
            assertTrue(queueOfTwoStack.peek().equals(0));
            assertNotNull(queueOfTwoStack.peek());
        }
    }

}