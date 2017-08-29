package BinaryTrees;

import org.junit.Test;

import static org.junit.Assert.*;

import BinaryTrees.GenBinaryTrees.TreeNode;

public class MorrisThroughTest {
    @Test
    public void morrisPost() throws Exception {
        TreeNode root = GenBinaryTrees.genBinaryTree(4);
        System.out.println(root);
//        TreeNode root=new TreeNode(16);
//        root.lChild=new TreeNode(5);
//        root.rChild=new TreeNode(8);
        String expected = OrderThrough.recursivePostOrder(root);
        String actual = MorrisThrough.morrisPost(root);
        assertEquals(expected, actual);
    }

    @Test
    public void morrisPre() throws Exception {
        TreeNode root = GenBinaryTrees.genBinaryTree(4);
        String expected = OrderThrough.recursivePreOrder(root);
        String actual = MorrisThrough.morrisPre(root);
        assertEquals(expected, actual);
    }

    @Test
    public void morrisIn() throws Exception {
        TreeNode root = GenBinaryTrees.genBinaryTree(4);
        String expected = OrderThrough.recursiveInOrder(root);
        String actual = MorrisThrough.morrisIn(root);
        assertEquals(expected, actual);
    }

}