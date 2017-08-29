package LinkLists;

import org.junit.Test;
import LinkLists.GenLinkedLists.MyLinkNode;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/9/2017.
 */
public class RemoveKthNodeTest {
    @Test
    public void removeKthNode() throws Exception {
        MyLinkNode node1 = GenLinkedLists.genStraightList(10);
        MyLinkNode node2 = (MyLinkNode) node1.clone();
        int len1 = node1.toString().length();
        node1=RemoveKthNode.removeKthNode1(node1, 10);
        node2=RemoveKthNode.removeKthNode2(node2, 10);
        int len2 = node1.toString().length();
        assertTrue(len1 > len2);
        assertEquals(node1, node2);
    }

}