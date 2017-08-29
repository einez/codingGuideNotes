package stackQueue;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 */
public class ReverseStack {
    public static <T> void reverseStack(Stack<T> stack){
        if(stack.empty())
            return;
        T obj=popBottom(stack);
        reverseStack(stack);
        stack.push(obj);
    }
    private static <T> T popBottom(Stack<T> stack){
        T top=stack.pop();
        if(stack.empty())
            return top;
        T obj=popBottom(stack);
        stack.push(top);
        return obj;
    }
}
