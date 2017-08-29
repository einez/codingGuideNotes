package BinaryTrees;

import org.junit.Test;

import static BinaryTrees.GenBinaryTrees.genBinaryTree;
import static org.junit.Assert.*;

/**
 * Created by einez on 8/11/2017.
 */
public class GenBinaryTreesTest {
    @Test
    public void printTree() throws Exception {
        GenBinaryTrees.TreeNode node=genBinaryTree(3);
        System.out.println(node);
        System.out.println(GenBinaryTrees.printTree(node));
    }

    @Test
    public void genBinaryTreeTest() throws Exception {
        GenBinaryTrees.TreeNode node=genBinaryTree(3);
        System.out.print(node);
    }

}