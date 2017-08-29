package stackQueue;

import java.util.Stack;

/**
 * 略费空间版
 */
public class GetMinStack1<T extends Comparable<T>> {
    private Stack<T> dataStack = new Stack<>();
    private Stack<T> minStack = new Stack<>();

    public T pop() {
        T obj = dataStack.pop();
        minStack.pop();
        return obj;
    }

    public T push(T item) {
        dataStack.push(item);
        if (!minStack.empty() && item.compareTo(minStack.peek()) > 0)
            item = minStack.peek();
        minStack.push(item);
        return dataStack.peek();
    }

    public T getMin() {
        return minStack.peek();
    }
}
