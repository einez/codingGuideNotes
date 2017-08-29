package BinaryTrees;

import org.junit.Test;

import static org.junit.Assert.*;

import BinaryTrees.GenBinaryTrees.TreeNode;

public class TwoErrInBSTTest {
    @Test
    public void findTwoErrsInBST() throws Exception {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(9);
        root.lChild = left;
        root.rChild = right;
        TreeNode[] expected = {root, left};
        assertArrayEquals(expected, TwoErrInBST.findTwoErrsInBST(root));
    }

}