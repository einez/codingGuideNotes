package stackQueue;

import java.util.Stack;

/**
 * Created by einez on 8/8/2017.
 */
public class SortStackWithOneStack {
    public static <T extends Comparable<T>> void sortStack(Stack<T> stack, boolean minTop) {
        if (stack.isEmpty())
            return;
        Stack<T> helper = new Stack<>();
        T tmp;
        while (!stack.isEmpty()) {
            while (helper.isEmpty() || !stack.isEmpty() && (minTop && stack.peek().compareTo(helper.peek()) >= 0 || !minTop && stack.peek().compareTo(helper.peek()) <= 0)) {
                helper.push(stack.pop());
            }
            if (!stack.isEmpty()) {
                tmp = stack.pop();
                while (!helper.isEmpty() && (minTop && tmp.compareTo(helper.peek()) < 0 || !minTop && tmp.compareTo(helper.peek()) > 0))
                    stack.push(helper.pop());
                helper.push(tmp);
            }
        }
        while (!helper.isEmpty())
            stack.push(helper.pop());
        return;
    }
}
