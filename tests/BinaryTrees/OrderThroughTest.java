package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderThroughTest {
    @Test
    public void inOrder() throws Exception {
        System.out.println("----In Order----");
        TreeNode root = GenBinaryTrees.genBinaryTree(4);
        System.out.println(root);
        String s1 = OrderThrough.recursiveInOrder(root);
        String s2 = OrderThrough.nonRecursiveInOrder(root);
        System.out.println(s1);
        System.out.println(s2);
        assertEquals(s1, s2);
    }

    @Test
    public void preOrder() throws Exception {
        System.out.println("----Pre Order----");
        TreeNode root = GenBinaryTrees.genBinaryTree();
        System.out.println(root);
        String s1 = OrderThrough.recursivePreOrder(root);
        String s2 = OrderThrough.nonRecursivePreOrder(root);
        System.out.println(s1);
        System.out.println(s2);
        assertEquals(s1, s2);
    }

    @Test
    public void postOrder() throws Exception {
        System.out.println("----Post Order----");
        TreeNode root = GenBinaryTrees.genBinaryTree(4);
        System.out.println(root);
        String s1 = OrderThrough.recursivePostOrder(root);
        String s2 = OrderThrough.nonRecursivePostOrder(root);
        System.out.println(s1);
        System.out.println(s2);
        assertEquals(s1, s2);
    }

}