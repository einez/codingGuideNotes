package _ch7Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadThroughTest {
    @Test
    public void throughInOrderThread() throws Exception {
        Tree.BTNode btNode = Tree.BTNode.createBTNode("1(2,3(,4(5,)))");
        Tree.ThreadBTNode threadBTNode = ThreadThrough.createByBTNode(btNode);
        Tree.ThreadBTNode root = ThreadThrough.createInOrderThread(threadBTNode);
        String expected = RecursiveThrough.inOrder(btNode);
        String actual = ThreadThrough.throughInOrderThread(root);
        assertEquals(expected, actual);
    }

}