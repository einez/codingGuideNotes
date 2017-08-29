package stackQueue;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class SortStackWithOneStackTest {
    @Test
    public void sortStack1() throws Exception {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        SortStackWithOneStack.sortStack(stack, true);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            assertTrue(stack.pop() == i);
        }
    }

    @Test
    public void sortStack2() throws Exception {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        SortStackWithOneStack.sortStack(stack, false);
        int size = stack.size();
        for (int i = size - 1; i >= 0; i--) {
            assertTrue(stack.pop() == i);
        }
    }

}