package LinkLists;

import org.junit.Test;
import LinkLists.GenLinkedLists.MyLinkNode;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/9/2017.
 */
public class MyLinkNodeTest {
    @Test
    public void equalsAndClone() throws Exception {
        MyLinkNode node1 = GenLinkedLists.genStraightList(10);
        MyLinkNode node2 = (MyLinkNode) node1.clone();
        assertEquals(node1, node2);
    }

}