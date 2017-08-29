package LinkLists;

import org.junit.Test;
import LinkLists.GenLinkedLists.MyLinkNode;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/9/2017.
 */
public class ReverseLinkedListTest {
    @Test
    public void reverseLinkedList() throws Exception {
        MyLinkNode head = GenLinkedLists.genStraightList(10);
        String[] strings = head.toString().split("->");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].isEmpty())
                sb.append("->" + strings[i]);
        }
        String originReverse = sb.toString();
        String modified = ReverseLinkedList.reverseLinkedList(head).toString();
        assertEquals(originReverse, modified);
    }

}