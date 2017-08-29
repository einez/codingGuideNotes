package LinkLists;

import LinkLists.GenLinkedLists.MyLinkNode;

/**
 * Created by einez on 8/9/2017.
 */
public class RemoveKthNode {
    public static MyLinkNode removeKthNode1(MyLinkNode head, int k) {
        if (k < 1)
            return head;
        MyLinkNode r = new MyLinkNode(0);
        MyLinkNode p = r;
        r.next = head;
        while (p.next != null) {
            p = p.next;
            k--;
        }
        if (k > 0)
            return head;
        p = r;
        while (k++ != 0) {
            p = p.next;
        }
        p.next = p.next == null ? null : p.next.next;
        return r.next;
    }

    public static MyLinkNode removeKthNode2(MyLinkNode head, int k) {
        if (k < 1)
            return head;
        MyLinkNode r = new MyLinkNode(0);
        MyLinkNode p = r;
        r.next = head;
        for (int i = 0; i < k; i++) {
            if (p.next == null)
                return head;
            p = p.next;
        }
        while (p.next != null) {
            r = r.next;
            p = p.next;
        }
        r.next = r.next == null ? null : r.next.next;
        return r.next;
    }
}
