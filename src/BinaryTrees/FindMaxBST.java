package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;

public class FindMaxBST {

    //    h.l<h<h.r只是BST的必要条件而非充分必要条件（h.l<h<h.r&&ltree.max<h<rtree.min）
//    public static TreeNode findMaxBST(TreeNode root) {
//        if (root == null)
//            return root;
//        TreeNode left = findMaxBST(root.lChild);
//        TreeNode right = findMaxBST(root.rChild);
//        if (root.lChild == left && root.rChild == right && (left == null || root.value > left.value) && (right == null || root.value < right.value))
//            return root;
//        else return getTreeNodeCount(left) > getTreeNodeCount(right) ? left : right;
//    }
//
//    private static int getTreeNodeCount(TreeNode root) {
//        if (root == null)
//            return 0;
//        return 1 + getTreeNodeCount(root.lChild) + getTreeNodeCount(root.rChild);
//    }
    public static TreeNode findMaxBST(TreeNode root) {
        return null;
    }

}
