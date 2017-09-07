package _ch7Tree;

import _ch7Tree.Tree.BTNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NonRecursiveThrough {
    public static String preOrder(BTNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<BTNode> stack = new Stack<>();

//        while (root != null) {
//            while (root != null) {
//                sb.append("#"+root.data);
//                if (root.rChild != null)
//                    stack.push(root.rChild);
//                root = root.lChild;
//            }
//            if (!stack.isEmpty())
//                root = stack.pop();
//        }
//        return sb.toString();

        stack.push(root);
        while (!stack.isEmpty()) {
            BTNode top = stack.pop();
            sb.append("#" + top.data);
            if (top.rChild != null)
                stack.push(top.rChild);
            if (top.lChild != null)
                stack.push(top.lChild);
        }
        return sb.toString();
    }

    public static String inOrder(BTNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<BTNode> stack = new Stack<>();

//        while (root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.lChild;
//            }
//            root = stack.pop();
//            sb.append("#"+root.data);
//            while (!stack.isEmpty() && root.rChild == null) {
//                root = stack.pop();
//                sb.append("#"+root.data);
//            }
//            root = root.rChild;
//        }
//        return sb.toString();

        while (root != null) {
            stack.push(root);
            root = root.lChild;
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            sb.append("#" + root.data);
            root = root.rChild;
            while (root != null) {
                stack.push(root);
                root = root.lChild;
            }
        }
        return sb.toString();
    }

    public static String postOrder(BTNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<BTNode> stack = new Stack<>();
        stack.push(root);
        BTNode lastVisited = null;
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root.lChild != null && root.lChild != lastVisited && (root.rChild == null || root.rChild != lastVisited)) {
                stack.push(root.lChild);
            } else if (root.rChild != null && root.rChild != lastVisited) {
                stack.push(root.rChild);
            } else {
                lastVisited = stack.pop();
                sb.append("#" + lastVisited.data);
            }
        }
        return sb.toString();
    }

    public static String layerThrough(BTNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<BTNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            root = qu.poll();
            sb.append("#" + root.data);
            if (root.lChild != null)
                qu.offer(root.lChild);
            if (root.rChild != null)
                qu.offer(root.rChild);
        }
        return sb.toString();
    }
}
