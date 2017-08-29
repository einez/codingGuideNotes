package LinkLists;
import LinkLists.GenLinkedLists.MyLinkNode;
/**
 * Created by einez on 8/9/2017.
 */
public class GetCommonOfTwoLists {

    public static MyLinkNode getCommonOfTwoLists(final MyLinkNode list1, final MyLinkNode list2) {
        if (list1 == null || list2 == null) return null;
        MyLinkNode p1 = list1, p2 = list2;
        while (p1 != p2) {
            p1 = p1.next == null ? list2 : p1.next;
            p2 = p2.next == null ? list1 : p2.next;
        }
        return p1;
    }
}
