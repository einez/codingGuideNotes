package stackQueue;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class ReverseStackTest {
    @Test
    public void reverseStack() throws Exception {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        ReverseStack.reverseStack(stack);
        for (int i = 9; i >= 0; i--) {
            System.out.print(stack.pop() );
//            assertTrue(stack.pop().equals(i));
        }
    }

}