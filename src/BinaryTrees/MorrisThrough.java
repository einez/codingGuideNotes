package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;

public class MorrisThrough {
    public static String morrisIn(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode subLeft;
        while (root != null) {
            subLeft = root.lChild;
            if (subLeft == null) {
                sb.append(" #" + root.value);
                root = root.rChild;
            } else {
                while (subLeft.rChild != null && subLeft.rChild != root) {
                    subLeft = subLeft.rChild;
                }
                if (subLeft.rChild == null) {
                    subLeft.rChild = root;
                    root = root.lChild;
                } else {
                    subLeft.rChild = null;
                    sb.append(" #" + root.value);
                    root = root.rChild;
                }
            }
        }
        return sb.toString();
    }

    public static String morrisPre(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode subLeft;
        while (root != null) {
            subLeft = root.lChild;
            if (subLeft == null) {
                sb.append(" #" + root.value);
                root = root.rChild;
            } else {
                while (subLeft.rChild != null && subLeft.rChild != root) {
                    subLeft = subLeft.rChild;
                }
                if (subLeft.rChild == null) {
                    subLeft.rChild = root;
                    sb.append(" #" + root.value);
                    root = root.lChild;
                } else {
                    subLeft.rChild = null;
                    root = root.rChild;
                }
            }
        }
        return sb.toString();
    }

    public static String morrisPost(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode subLeft = new TreeNode(0);
        subLeft.lChild = root;
        root = subLeft;
        while (root != null) {
            subLeft = root.lChild;
            if (subLeft == null) {
                root = root.rChild;
            } else {
                while (subLeft.rChild != null && subLeft.rChild != root) {
                    subLeft = subLeft.rChild;
                }
                if (subLeft.rChild == null) {
                    subLeft.rChild = root;
                    root = root.lChild;
                } else {
                    subLeft.rChild = null;
                    recerseAppendRchild(sb, root.lChild);
                    root = root.rChild;
                }
            }
        }
        return sb.toString();
    }

    private static void recerseAppendRchild(StringBuilder sb, TreeNode lChild) {
        TreeNode h1 = lChild;
        TreeNode h2 = h1.rChild;
        h1.rChild = null;
        TreeNode p;
        while (h2 != null) {
            p = h2.rChild;
            h2.rChild = h1;
            h1 = h2;
            h2 = p;
        }
        h2 = h1.rChild;
        h1.rChild = null;
        while (h2 != null) {
            sb.append(" #" + h1.value);
            p = h2.rChild;
            h2.rChild = h1;
            h1 = h2;
            h2 = p;
        }
        sb.append(" #" + h1.value);
    }
}
