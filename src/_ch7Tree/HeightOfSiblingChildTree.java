package _ch7Tree;

import _ch7Tree.Tree.SCTNode;

public class HeightOfSiblingChildTree {
    public static int getTreeHeight(SCTNode root) {
        if (root == null)
            return 0;
        else if (root.child == null)
            return 1;
        else {
            int max = 0;
            SCTNode p = root.child;
            while (p != null) {
                max = Math.max(max, getTreeHeight(p));
                p = p.sibling;
            }
            return 1 + max;
        }
    }
}
