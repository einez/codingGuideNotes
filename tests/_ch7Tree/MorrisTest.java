package _ch7Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MorrisTest {
    @Test
    public void postOrder() throws Exception {
        String str = "1(2(,4(5,6(,7))),3(1,9))";
        Contract.BTNode root = Contract.BTNode.createBTNode(str);
        String expected = RecursiveThrough.postOrder(root);
        String actual = Morris.postOrder(root);
        assertEquals(expected, actual);
    }

    @Test
    public void preOrder() throws Exception {
        String str = "1(2(,4(5,6(,7))),3(1,9))";
        Contract.BTNode root = Contract.BTNode.createBTNode(str);
        String expected = RecursiveThrough.preOrder(root);
        String actual = Morris.preOrder(root);
        assertEquals(expected, actual);
    }

    @Test
    public void inOrderTest() throws Exception {
        String str = "1(2(,4(5,6(,7))),3(1,9))";
        Contract.BTNode root = Contract.BTNode.createBTNode(str);
        String expected = RecursiveThrough.inOrder(root);
        String actual = Morris.inOrder(root);
        assertEquals(expected, actual);
    }

}