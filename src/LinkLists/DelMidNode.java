package LinkLists;
import LinkLists.GenLinkedLists.MyLinkNode;
/**
 * Created by einez on 8/9/2017.
 */
public class DelMidNode {
    public static MyLinkNode delMidNode(MyLinkNode head){
        if(head==null||head.next==null)
            return head;
        MyLinkNode r=new MyLinkNode(0);
        MyLinkNode p1=r,p2=r.next;
        while(p2.next.next!=null&&p2.next.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        return p1.next;
    }
}
