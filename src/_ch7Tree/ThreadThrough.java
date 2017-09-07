package _ch7Tree;

import _ch7Tree.Tree.BTNode;
import _ch7Tree.Tree.ThreadBTNode;

public class ThreadThrough {
    public static ThreadBTNode createByBTNode(BTNode root) {
        if (root == null)
            return null;
        ThreadBTNode copy = new ThreadBTNode(root.data);
        copy.lChild = createByBTNode(root.lChild);
        copy.rChild = createByBTNode(root.rChild);
        return copy;
    }

    public static ThreadBTNode createInOrderThread(ThreadBTNode root) {
        ThreadBTNode head = new ThreadBTNode(0);
        ThreadBTNode[] pre = new ThreadBTNode[]{head};
        createInOrderThread(root, pre);
        head.lChild = root == null ? head : root;
        head.rChild = pre[0];
        pre[0].rtag = 1;
        pre[0].rChild = head;
        return head;
    }

    private static void createInOrderThread(ThreadBTNode root, ThreadBTNode[] pre) {
        if (root == null)
            return;
        createInOrderThread(root.lChild, pre);
        if (pre[0].rChild == null) {
            pre[0].rtag = 1;
            pre[0].rChild = root;
        }
        if (root.lChild == null) {
            root.ltag = 1;
            root.lChild = pre[0];
        }
        pre[0] = root;
        createInOrderThread(root.rChild, pre);
    }

    public static String throughInOrderThread(ThreadBTNode head) {
        if (head.lChild == head)
            return "";
        StringBuilder sb = new StringBuilder();
        ThreadBTNode p = head.lChild;
        while (p != head) {
            while (p.ltag == 0)
                p = p.lChild;
            while (p.rtag == 1 && p.rChild != head) {
                sb.append("#" + p.data);
                p = p.rChild;
            }
            sb.append("#" + p.data);
            p = p.rChild;
        }
        return sb.toString();
    }
}
