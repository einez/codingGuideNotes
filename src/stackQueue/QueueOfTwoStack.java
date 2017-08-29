package stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by einez on 8/8/2017.
 */
public class QueueOfTwoStack<T> {
    private Queue<T> queue = new LinkedList<>();
    private Stack<T> pushStack = new Stack<>();
    private Stack<T> popStack = new Stack<>();

    public boolean add(T item) {
        pushStack.push(item);
        return true;
    }

    public T poll() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        if (popStack.empty())
            return null;
        return popStack.pop();
    }

    public T peek() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        if (popStack.empty())
            return null;
        return popStack.peek();
    }
}
