package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;

import java.util.Stack;

/**
 * Created by einez on 8/11/2017.
 */
public class OrderThrough {
    public static String nonRecursiveInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            while (top != null) {
                stack.push(top);
                top = top.lChild;
            }
            if (!stack.isEmpty()) {
                top = stack.pop();
                sb.append(" #" + top.value);
                stack.push(top.rChild);
            }
        }
        return sb.toString();
    }
//    public static String nonRecursiveInOrder(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        while (root != null) {
//            stack.push(root);
//            root = root.lChild;
//        }
//        while (!stack.isEmpty()) {
//            TreeNode top = stack.pop();
//            sb.append(" #" + top.value);
//            if (top.rChild != null) {
//                stack.push(top.rChild);
//                top = top.rChild.lChild;
//                while (top != null) {
//                    stack.push(top);
//                    top = top.lChild;
//                }
//            }
//        }
//        return sb.toString();
//    }

    public static String recursiveInOrder(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(recursiveInOrder(root.lChild));
        sb.append(" #" + root.value);
        sb.append(recursiveInOrder(root.rChild));
        return sb.toString();
    }

    public static String nonRecursivePreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            sb.append(" #" + top.value);
            if (top.rChild != null)
                stack.push(top.rChild);
            if (top.lChild != null)
                stack.push(top.lChild);
        }
        return sb.toString();
    }
//    public static String nonRecursivePreOrder(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode top = stack.pop();
//            while (top != null) {
//                sb.append(" #" + top.value);
//                if (top.rChild != null)
//                    stack.push(top.rChild);
//                top = top.lChild;
//            }
//        }
//        return sb.toString();
//    }

    public static String recursivePreOrder(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(" #" + root.value);
        sb.append(recursivePreOrder(root.lChild));
        sb.append(recursivePreOrder(root.rChild));
        return sb.toString();
    }

    public static String nonRecursivePostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);
        TreeNode lastVisited = root;
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.lChild != null && lastVisited != top.lChild && lastVisited != top.rChild)
                stack.push(top.lChild);
            else if (top.rChild != null && lastVisited != top.rChild)
                stack.push(top.rChild);
            else {
                lastVisited = stack.pop();
                sb.append(" #" + lastVisited.value);
            }
        }
        return sb.toString();
    }
//while嵌套，课本解法
//    public static String nonRecursivePostOrder(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        do{
//            while (root!=null){
//                stack.push(root);
//                root=root.lChild;
//            }
//            TreeNode lastVisited=null;
//            while(!stack.isEmpty()&&
//                    (stack.peek().rChild==lastVisited||
//                    stack.peek().rChild==null)){
//                lastVisited=stack.pop();
//                sb.append(" #"+lastVisited.value);
//            }
//            root=stack.isEmpty()?null:stack.peek().rChild;
//        }while (!stack.isEmpty());
//        return sb.toString();
//    }
//右节点也压栈， :( NOT GOOD
//    public static String nonRecursivePostOrder(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        stack.push(root);
//        TreeNode lastPop = root;
//        while (!stack.isEmpty()) {
//            TreeNode top = stack.peek();
//            if (lastPop == top.lChild || lastPop == top.rChild || top.lChild == null && top.rChild == null) {
//                lastPop = stack.pop();
//                sb.append(" #" + top.value);
//            } else {
//                if (top.rChild != null)
//                    stack.push(top.rChild);
//                if (top.lChild != null)
//                    stack.push(top.lChild);
//            }
//        }
//        return sb.toString();
//    }

    public static String recursivePostOrder(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(recursivePostOrder(root.lChild));
        sb.append(recursivePostOrder(root.rChild));
        sb.append(" #" + root.value);
        return sb.toString();
    }
}
