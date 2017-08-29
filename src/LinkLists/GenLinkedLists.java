package LinkLists;

import java.util.Random;

/**
 * Created by einez on 8/9/2017.
 */
public class GenLinkedLists {
    public static class MyLinkNode {
        int value;
        MyLinkNode next;

        public MyLinkNode(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            MyLinkNode node = this;
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append("->" + node.value);
                node = node.next;
            }
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MyLinkNode) {
                MyLinkNode comp1 = (MyLinkNode) obj;
                MyLinkNode comp2 = this;
                while (comp1 != null && comp2 != null) {
                    if (comp1.value != comp2.value)
                        return false;
                    comp1 = comp1.next;
                    comp2 = comp2.next;
                }
                if (comp1 == null && comp2 == null)
                    return true;
            }
            return false;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            MyLinkNode copy = new MyLinkNode(this.value);
            MyLinkNode tail1 = this, tail2 = copy;
            while (tail1.next != null) {
                tail2.next = new MyLinkNode(tail1.next.value);
                tail1 = tail1.next;
                tail2 = tail2.next;
            }
            return copy;
        }
    }

    public static MyLinkNode genStraightList(int len) {
        return genStraightList(len, 20);
    }

    public static MyLinkNode genStraightList(int len, int valueBound) {
        Random random = new Random();
        MyLinkNode list = new MyLinkNode(random.nextInt(valueBound));
        MyLinkNode p = list;
        for (int i = 0; i < len - 1; i++) {
            p.next = new MyLinkNode(random.nextInt(valueBound));
            p = p.next;
        }
        return list;
    }


    public static MyLinkNode genPartLoopedList(int len) {
        return genPartLoopedList(len, 20);
    }

    /**
     * @param len        is the length of the list you expected to return.
     * @param valueBound is the value range of nodes is [0,valueBound), default valueBound is 20
     * @return return a looped linkedList, it may be partly looped or entirely looped.
     */
    public static MyLinkNode genPartLoopedList(int len, int valueBound) {
        Random random = new Random();
        MyLinkNode list = new MyLinkNode(random.nextInt(valueBound));
        MyLinkNode p = list;
        int loopStart = random.nextInt(len - 1);
        MyLinkNode loopStartNode = null;
        for (int i = 0; i < len - 1; i++) {
            if (i == loopStart)
                loopStartNode = p;
            p.next = new MyLinkNode(random.nextInt(valueBound));
            p = p.next;
        }
        p.next = loopStartNode;
        return list;
    }
}
