package _ch7Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadThroughTest {
    @Test
    public void throughInOrderThread() throws Exception {
        Contract.BTNode btNode = Contract.BTNode.createBTNode("1(2,3(,4(5,)))");
        Contract.ThreadBTNode threadBTNode = ThreadThrough.createByBTNode(btNode);
        Contract.ThreadBTNode root = ThreadThrough.createInOrderThread(threadBTNode);
        String expected = RecursiveThrough.inOrder(btNode);
        String actual = ThreadThrough.throughInOrderThread(root);
        assertEquals(expected, actual);
    }

}