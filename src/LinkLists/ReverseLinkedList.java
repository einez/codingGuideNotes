package LinkLists;

import LinkLists.GenLinkedLists.MyLinkNode;

/**
 * Created by einez on 8/9/2017.
 */
public class ReverseLinkedList {
    public static MyLinkNode reverseLinkedList(MyLinkNode head) {
        if (head == null || head.next == null)
            return head;
        MyLinkNode p = head, q = head.next, r;
        p.next = null;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}
