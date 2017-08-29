package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;

public class TwoErrInBST {
    public static TreeNode[] findTwoErrsInBST(TreeNode root) {
        TreeNode[] errs = {null, null};
        TreeNode floor = new TreeNode(Integer.MIN_VALUE);
        TreeNode ceiling = new TreeNode(Integer.MAX_VALUE);
        findTwoErrsInBST(root, errs, floor, ceiling);
        return errs;
    }

    private static boolean findTwoErrsInBST(TreeNode root, TreeNode[] errs, TreeNode floor, TreeNode ceiling) {
        if (root == null)
            return false;
        if (root.value < floor.value) {
            errs[0] = root;
            if (errs[1] != null)
                return true;
            errs[1] = floor;
        } else if (root.value > ceiling.value) {
            errs[1] = root;
            if (errs[0] != null)
                return true;
            errs[0] = ceiling;
        } else {
            if (findTwoErrsInBST(root.lChild, errs, floor, root))
                return true;
            if (findTwoErrsInBST(root.rChild, errs, root, ceiling))
                return true;
            if (errs[0] == root || errs[1] == root)
                return true;
        }
        return false;
    }
}
