package BinaryTrees;

import org.junit.Test;

import static org.junit.Assert.*;

import BinaryTrees.GenBinaryTrees.TreeNode;


public class FindMaxBSTTest {
    @Test
    public void findMaxBST() throws Exception {
        TreeNode n6 = new TreeNode(6);
        TreeNode n1 = new TreeNode(1);
        TreeNode n12 = new TreeNode(12);
        n6.lChild = n1;
        n6.rChild = n12;
        TreeNode n0 = new TreeNode(0);
        TreeNode n3 = new TreeNode(3);
        n1.lChild = n0;
        n1.rChild = n3;
        TreeNode n10 = new TreeNode(10);
        TreeNode n13 = new TreeNode(13);
        n12.lChild = n10;
        n12.rChild = n13;
        TreeNode n4 = new TreeNode(4);
        TreeNode n14 = new TreeNode(14);
        n10.lChild = n4;
        n10.rChild = n14;
        TreeNode n20 = new TreeNode(20);
        TreeNode n16 = new TreeNode(16);
        n13.lChild = n20;
        n13.rChild = n16;
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        n4.lChild = n2;
        n4.rChild = n5;
        TreeNode n11 = new TreeNode(11);
        TreeNode n15 = new TreeNode(15);
        n14.lChild = n11;
        n14.rChild = n15;
//        TreeNode actual = FindMaxBST.findMaxBST(n6);
//        TreeNode expected = n10;
//        assertEquals(expected, actual);
    }

}