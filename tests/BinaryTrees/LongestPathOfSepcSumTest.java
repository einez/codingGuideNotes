package BinaryTrees;

import org.junit.Test;

import static org.junit.Assert.*;

import BinaryTrees.GenBinaryTrees.TreeNode;

public class LongestPathOfSepcSumTest {
    @Test
    public void getLongestPathOfSepcSum() throws Exception {
        TreeNode root = new TreeNode(-3);
        TreeNode layer21 = new TreeNode(3);
        TreeNode layer22 = new TreeNode(-9);
        TreeNode layer31 = new TreeNode(1);
        TreeNode layer32 = new TreeNode(0);
        TreeNode layer33 = new TreeNode(2);
        TreeNode layer34 = new TreeNode(1);
        TreeNode layer41 = new TreeNode(1);
        TreeNode layer42 = new TreeNode(6);
        root.lChild = layer21;
        root.rChild = layer22;
        layer21.lChild = layer31;
        layer21.rChild = layer32;
        layer22.lChild = layer33;
        layer22.rChild = layer34;
        layer32.lChild = layer41;
        layer32.rChild = layer42;
        assertEquals(4, LongestPathOfSepcSum.getLongestPathOfSepcSum(root, 6));
        assertEquals(1, LongestPathOfSepcSum.getLongestPathOfSepcSum(root, -9));
        assertEquals(4, LongestPathOfSepcSum.solutionInBook(root, 6));
        assertEquals(1, LongestPathOfSepcSum.solutionInBook(root, -9));
    }

}