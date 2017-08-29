package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;

public class FindMaxBSTTopo {
    public static TreeNode findMaxBSTTopo(TreeNode root) {
        //0:head, 1:maxSub
        //0:size, 1:minValue, 2:maxValue
        int[][] record = new int[2][3];
        //0:head, 1:maxSub
        TreeNode[] topos = {null, null};
        findMaxBSTTopo(root, topos, record, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return topos[1];
    }

    private static void findMaxBSTTopo(TreeNode root, TreeNode[] topos, int[][] record, int minValue, int maxValue) {
        if (root == null || root.value < minValue || root.value > maxValue) {
            for (int i = 0; i < 2; i++) {
                topos[i] = null;
                record[i][0] = 0;
                record[i][1] = Integer.MAX_VALUE;
                record[i][2] = Integer.MIN_VALUE;
            }
            return;
        }
        TreeNode pHead = new TreeNode(root.value);
        int[] pRec = {1, minValue, maxValue};
        findMaxBSTTopo(root.lChild, topos, record, minValue, root.value);
        if (root.lChild != null && root.value >= root.lChild.value) {
            pHead.lChild = topos[0];
            pRec[0] += record[0][0];
            pRec[1] = Math.min(pRec[1], record[0][1]);
        }
        findMaxBSTTopo(root.rChild, topos, record, root.value, maxValue);
        if (root.rChild != null && root.value <= root.rChild.value) {
            pHead.rChild = topos[0];
            pRec[0] += record[0][0];
            pRec[2] = Math.max(pRec[2], record[0][2]);
        }
        topos[0] = pHead;
        for (int i = 0; i < 3; i++) {
            record[0][i] = pRec[i];
        }
        if (record[1][0] <= record[0][0]) {
            topos[1] = topos[0];
            for (int i = 0; i < 3; i++) {
                record[1][i] = record[0][i];
            }
        }
//
//        topos[0] = new TreeNode(root.value);
//        record[0][0] = 1;
//        record[0][1] = root.value;
//        record[0][2] = root.value;
//
//        int[][] lRec = new int[2][3];
//        TreeNode[] ltos = new TreeNode[2];
//        findMaxBSTTopo(root.lChild, ltos, lRec, minValue, root.value);
//
//        if (root.lChild != null && root.lChild.value <= root.value) {
//            topos[0].lChild = ltos[0];
//            record[0][0] += lRec[0][0];
//            if (record[0][1] > lRec[0][1])
//                record[0][1] = lRec[0][1];
//        }
//
//        int[][] rRec = new int[2][3];
//        TreeNode[] rtos = new TreeNode[2];
//        findMaxBSTTopo(root.lChild, rtos, rRec, root.value, maxValue);
//
//        if (root.rChild != null && root.rChild.value >= root.value) {
//            topos[0].rChild = rtos[0];
//            record[0][0] += lRec[0][0];
//            if (record[0][2] < rRec[0][2])
//                record[0][2] = lRec[0][2];
//        }
//
//        if(record[0][0]>=lRec[1][0]&&record[0][0]>=rRec[1][0]){
//            topos[1]=topos[0];
//            for (int i = 0; i < 3; i++) {
//                record[1][i]=record[0][i];
//            }
//        }else if(lRec[1][0]>rRec[1][0]){
//            topos[1]=ltos[1];
//            for (int i = 0; i < 3; i++) {
//                record[1][i]=lRec[1][i];
//            }
//        }else {
//            topos[1]=rtos[1];
//            for (int i = 0; i < 3; i++) {
//                record[1][i]=rRec[1][i];
//            }
//        }
    }
}
