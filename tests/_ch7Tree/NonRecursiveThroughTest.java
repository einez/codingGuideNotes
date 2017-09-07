package _ch7Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NonRecursiveThroughTest {
    @Test
    public void layerThrough() throws Exception {
        String str = "1(2,3(4(5,6),))";
        String expected = "#1#2#3#4#5#6";
        String actual = NonRecursiveThrough.layerThrough(Tree.BTNode.createBTNode(str));
        assertEquals(expected, actual);
    }

    @Test
    public void preOrder() throws Exception {
        String str = "3(45(,38(1(,0),)),6(5,4))";
        Tree.BTNode root = Tree.BTNode.createBTNode(str);
        String expected = RecursiveThrough.preOrder(root);
        String actual = NonRecursiveThrough.preOrder(root);
        assertEquals(expected, actual);
    }

    @Test
    public void inOrder() throws Exception {
        String str = "3(45(,38(1(,0),)),6(5,4))";
        Tree.BTNode root = Tree.BTNode.createBTNode(str);
        String expected = RecursiveThrough.inOrder(root);
        String actual = NonRecursiveThrough.inOrder(root);
        assertEquals(expected, actual);
    }

    @Test
    public void postOrder() throws Exception {
        String str = "3(45(,38(1(,0),)),6(5,4))";
        Tree.BTNode root = Tree.BTNode.createBTNode(str);
        String expected = RecursiveThrough.postOrder(root);
        String actual = NonRecursiveThrough.postOrder(root);
        assertEquals(expected, actual);
    }

}