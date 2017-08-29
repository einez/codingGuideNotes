package LinkLists;

import org.junit.Test;
import LinkLists.GenLinkedLists.MyLinkNode;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/9/2017.
 */
public class DelMidNodeTest {
    @Test
    public void delMidNode() throws Exception {
        MyLinkNode head = GenLinkedLists.genStraightList(2);
        head = DelMidNode.delMidNode(head);
        assertNull(head.next);
    }

}