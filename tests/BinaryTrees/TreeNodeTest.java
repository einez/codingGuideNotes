package BinaryTrees;

import org.junit.Test;
import BinaryTrees.GenBinaryTrees.TreeNode;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/11/2017.
 */
public class TreeNodeTest {
    @Test
    public void toStringTest() throws Exception {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.lChild = node2;
        node1.rChild = node3;
        node2.rChild = node4;
        node3.lChild = node5;
        System.out.print(node1);
    }

}