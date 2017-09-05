package _ch7Tree;

import _ch7Tree.Contract.BTNode;

public class RecursiveThrough {
    public static String preOrder(BTNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append("#" + root.data);
        sb.append(preOrder(root.lChild));
        sb.append(preOrder(root.rChild));
        return sb.toString();
    }

    public static String inOrder(BTNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(inOrder(root.lChild));
        sb.append("#" + root.data);
        sb.append(inOrder(root.rChild));
        return sb.toString();
    }

    public static String postOrder(BTNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(postOrder(root.lChild));
        sb.append(postOrder(root.rChild));
        sb.append("#" + root.data);
        return sb.toString();
    }
}
