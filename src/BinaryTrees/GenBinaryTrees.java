package BinaryTrees;

import java.util.Random;

/**
 * Created by einez on 8/11/2017.
 */
public class GenBinaryTrees {
    private static Random random = new Random();

    public static class TreeNode {
        public int value;
        public TreeNode lChild;
        public TreeNode rChild;

        public TreeNode(int value) {
            this.value = value;
            this.lChild = null;
            this.rChild = null;
        }

        @Override
        public String toString() {
            if (this.lChild == null && this.rChild == null)
                return String.valueOf(this.value);
//                return "["+String.valueOf(this.value)+"]";
            return "[#" + String.valueOf(this.value) + ", (" + lChild + ", " + rChild + ")]";
        }
    }

    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.lChild), getHeight(root.rChild));
    }

    public static String printTree(TreeNode root) {
//        int height=getHeight(root);
        return printTree(root, 0, 'H');
    }

    private static String printTree(TreeNode root, int height, char c) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(printTree(root.rChild, height + 1, 'V'));
        for (int i = 0; i < height; i++) {
            sb.append(String.format("%17s", " "));
        }
        sb.append(String.format(" %15s %n", c + String.valueOf(root.value) + c));
        sb.append(printTree(root.lChild, height + 1, 'A'));
        return sb.toString();
    }

    public static TreeNode genBinaryTree() {
        return genBinaryTree(random.nextInt(5) + 1);
    }

    public static TreeNode genBinaryTree(int height) {
        if (height <= 0)
            return null;
        else if (height == 1)
            return new TreeNode(random.nextInt(20));
        TreeNode root = new TreeNode(random.nextInt(20));
        int lHeight, rHeight;
        if (random.nextInt() % 2 == 0) {
            lHeight = height - 1;
            rHeight = random.nextInt(height);
        } else {
            lHeight = random.nextInt(height);
            rHeight = height - 1;
        }
        root.lChild = genBinaryTree(lHeight);
        root.rChild = genBinaryTree(rHeight);
        return root;
    }
}
