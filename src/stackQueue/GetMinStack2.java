package stackQueue;

import java.util.Stack;

/**
 * 略费时间版
 */
public class GetMinStack2<T extends Comparable<T>> {
    private Stack<T> dataStack = new Stack<>();
    private Stack<T> minStack = new Stack<>();

    public T pop() {
        T obj = dataStack.pop();
        if (obj.compareTo(minStack.peek()) <= 0)
            minStack.pop();
        return obj;
    }

    public T push(T item) {
        dataStack.push(item);
        if (minStack.empty() || item.compareTo(minStack.peek()) <= 0)
            minStack.push(item);
        return dataStack.peek();
    }

    public T getMin() {
        return minStack.peek();
    }
}
