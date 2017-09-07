package _ch7Tree;

import _ch7Tree.Tree.BTNode;

public class Morris {
    public static String inOrder(BTNode root) {
        StringBuilder sb = new StringBuilder();
        while (root != null) {
            BTNode p = root.lChild;
            if (p != null) {
                while (p.rChild != null && p.rChild != root) {
                    p = p.rChild;
                }
                if (p.rChild == null) {
                    p.rChild = root;
                    root = root.lChild;
                } else {
                    p.rChild = null;
                    sb.append("#" + root.data);
                    root = root.rChild;
                }
            } else {
                sb.append("#" + root.data);
                root = root.rChild;
            }
        }
        return sb.toString();
    }

    public static String preOrder(BTNode root) {
        StringBuilder sb = new StringBuilder();
        while (root != null) {
            BTNode p = root.lChild;
            if (p != null) {
                while (p.rChild != null && p.rChild != root) {
                    p = p.rChild;
                }
                if (p.rChild == null) {
                    sb.append("#" + root.data);
                    p.rChild = root;
                    root = root.lChild;
                } else {
                    p.rChild = null;
                    root = root.rChild;
                }
            } else {
                sb.append("#" + root.data);
                root = root.rChild;
            }
        }
        return sb.toString();
    }

    public static String postOrder(BTNode root) {
        StringBuilder sb = new StringBuilder();
        BTNode head = new BTNode(0);
        head.lChild = root;
        root = head;
        while (root != null) {
            BTNode p = root.lChild;
            if (p != null) {
                while (p.rChild != null && p.rChild != root) {
                    p = p.rChild;
                }
                if (p.rChild == null) {
                    p.rChild = root;
                    root = root.lChild;
                } else {
                    p.rChild = null;
                    reverseAppendRTree(sb, root.lChild);
                    root = root.rChild;
                }
            } else {
                root = root.rChild;
            }
        }
        return sb.toString();
    }

    private static void reverseAppendRTree(StringBuilder sb, BTNode node) {
        if (node.rChild == null) {
            sb.append("#" + node.data);
            return;
        }
        BTNode p = node;
        BTNode q1 = node.rChild;
        BTNode q2;
        p.rChild = null;
        while (q1 != null) {
            q2 = q1.rChild;
            q1.rChild = p;
            p = q1;
            q1 = q2;
        }
        sb.append("#" + p.data);
        q1 = p.rChild;
        p.rChild = null;
        while (q1 != null) {
            q2 = q1.rChild;
            q1.rChild = p;
            p = q1;
            sb.append("#" + p.data);
            q1 = q2;
        }
    }
}
