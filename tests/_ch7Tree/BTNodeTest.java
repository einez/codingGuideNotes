package _ch7Tree;

import _ch7Tree.Contract.BTNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BTNodeTest {
    @Test
    public void createBTNodeWithPreIn() throws Exception {
        String str = "1(24(,6(4,15(5,10))),3(4,35))";//注意各个值互不相等
        BTNode root = BTNode.createBTNode(str);
        String preString = RecursiveThrough.preOrder(root);
        String inString = RecursiveThrough.inOrder(root);
        BTNode copy = Contract.BTNode.createBTNodeWithPreIn(preString, inString);
        String actual = copy.toString();
        assertEquals(str, actual);
    }

    @Test
    public void createBTNodeWithPostIn() throws Exception {
        String str = "1(24(,6(4,15(5,10))),3(4,35))";//注意各个值互不相等
        BTNode root = BTNode.createBTNode(str);
        String postString = RecursiveThrough.postOrder(root);
        String inString = RecursiveThrough.inOrder(root);
        BTNode copy = Contract.BTNode.createBTNodeWithPostIn(postString, inString);
        String actual = copy.toString();
        assertEquals(str, actual);
    }

    @Test
    public void createBTNodeTest() throws Exception {
        String str = "1(24(,6(4,5(5,10))),3(4,5))";
        BTNode root = BTNode.createBTNode(str);
        assertEquals(str, root.toString());
    }

    @Test
    public void findNodeTest() throws Exception {
        String str = "1(24(,6(4,5(5,10))),3(4,5))";
        BTNode root = BTNode.createBTNode(str);
        assertEquals("24(,6(4,5(5,10)))", BTNode.findNode(root, 24).toString());
    }

    @Test
    public void getHeightTest() throws Exception {
        String str = "5(5(,10),)";
        int expected = 3;
        int actual = BTNode.getHeight(BTNode.createBTNode(str));
        assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() throws Exception {
        BTNode root = new BTNode(1);
        BTNode lc = new BTNode(2);
        BTNode rc = new BTNode(3);
        BTNode rc1 = new BTNode(4);
        BTNode rc2 = new BTNode(5);
        root.lChild = lc;
        root.rChild = rc;
        rc.lChild = rc1;
        rc.rChild = rc2;
        System.out.println(root);
    }

}