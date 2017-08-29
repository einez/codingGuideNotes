package LinkLists;

import org.junit.Test;
import LinkLists.GenLinkedLists.MyLinkNode;

import static org.junit.Assert.*;


/**
 * Created by einez on 8/9/2017.
 */
public class PrintCommonOfTwoListsTest {
    @Test
    public void printCommonOfTwoLists() throws Exception {
        MyLinkNode list1 = GenLinkedLists.genStraightList(7);
        MyLinkNode list2 = GenLinkedLists.genStraightList(12);
        MyLinkNode list3 = GenLinkedLists.genStraightList(6);
        MyLinkNode p = list1;
        while (p.next != null)
            p = p.next;
        p.next = list3;
        p = list2;
        while (p.next != null)
            p = p.next;
        p.next = list3;
        System.out.println(list1);
        System.out.println(list2);
        assertTrue(GetCommonOfTwoLists.getCommonOfTwoLists(list1, list2) == list3);
    }

}