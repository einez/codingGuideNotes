package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;

import java.util.*;

import static BinaryTrees.GenBinaryTrees.getHeight;

public class PrintBound {

    public static String standard2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> firstLeafPath = null;
        LinkedList<TreeNode> lastLeafPath = null;
        TreeNode lastVisited = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root.lChild != lastVisited && root.rChild != lastVisited && root.lChild != null) {
                stack.push(root.lChild);
            } else if (root.rChild != lastVisited && root.rChild != null) {
                stack.push(root.rChild);
            } else {
                lastVisited = stack.pop();
                if (root.lChild == null && root.rChild == null) {
                    if (firstLeafPath == null) {
                        firstLeafPath = new LinkedList<>(stack);
                        for (TreeNode node : firstLeafPath)
                            sb.append(node.value + " ");
                    }
                    lastLeafPath = new LinkedList<>(stack);
                    sb.append(lastVisited.value + " ");
                }
            }
        }
        lastLeafPath.removeAll(firstLeafPath);
        while (!lastLeafPath.isEmpty())
            sb.append(lastLeafPath.pollLast().value + " ");
        return sb.toString();
    }

    //    -----------------------in book------------------------------------------
    public static String standard1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        int height = getHeight(root);
        TreeNode[][] boundArray = new TreeNode[height][2];
        fillBoundArray(root, 0, boundArray);
        for (int i = 0; i < height; i++) {
            sb.append(boundArray[i][0].value + " ");
        }
        appendLeafNotInBoundArray(root, 0, boundArray, sb);
        for (int i = height - 1; i >= 1; i--) {
            sb.append(boundArray[i][1].value + " ");
        }
        return sb.toString();
    }

    private static void appendLeafNotInBoundArray(TreeNode root, int height, TreeNode[][] boundArray, StringBuilder sb) {
        if (root == null)
            return;
        if (root.lChild == null && root.rChild == null && root != boundArray[height][0] && root != boundArray[height][1])
            sb.append(root.value + " ");
        else {
            appendLeafNotInBoundArray(root.lChild, height + 1, boundArray, sb);
            appendLeafNotInBoundArray(root.rChild, height + 1, boundArray, sb);
        }
    }

    private static void fillBoundArray(TreeNode root, int height, TreeNode[][] boundArray) {
        if (root == null)
            return;
        if (boundArray[height][0] == null)
            boundArray[height][0] = root;
        boundArray[height][1] = root;
        fillBoundArray(root.lChild, height + 1, boundArray);
        fillBoundArray(root.rChild, height + 1, boundArray);
    }


//    -----------------------success------------------------------------------
//    private static TreeMap<Integer, TreeNode> leftMost = new TreeMap<Integer, TreeNode>(
////            new Comparator<Integer>() {
////                @Override
////                public int compare(Integer o1, Integer o2) {
////                    return o1.compareTo(o2);
////                }
////            }
//    );
//    private static TreeMap<Integer, TreeNode> rightMost = new TreeMap<Integer, TreeNode>(
//            new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2.compareTo(o1);
//                }
//            }
//    );
//
//    public static String standard1(TreeNode root) {
//        initBoundNodesMaps(root);
//        StringBuilder sb = new StringBuilder();
//        for (TreeNode lm : leftMost.values()) {
//            sb.append(lm.value + " ");
//        }
//        getLeafNotInMap(root, sb);
//        for (TreeNode rm : rightMost.values()) {
//            sb.append(rm.value + " ");
//        }
//        return sb.toString();
//    }
//
//    private static void getLeafNotInMap(TreeNode root, StringBuilder sb) {
//        if (root == null)
//            return;
//        if (isLeaf(root) && !leftMost.containsValue(root) && !rightMost.containsValue(root))
//            sb.append(root.value + " ");
//        getLeafNotInMap(root.lChild, sb);
//        getLeafNotInMap(root.rChild, sb);
//    }
////    public static String Standard1(TreeNode root) {
////        initBoundNodesMaps(root);
////        Stack<TreeNode> stack = new Stack<>();
////        stack.push(root);
////        StringBuilder sb = new StringBuilder();
////        for (TreeNode lm : leftMost.values()) {
////            sb.append(lm.value + " ");
////        }
////        while (!stack.isEmpty()) {
////            TreeNode top = stack.pop();
////            if (isLeaf(top) && !leftMost.containsValue(top) && !rightMost.containsValue(top))
////                sb.append(top.value + " ");
////            if (top.rChild != null)
////                stack.push(top.rChild);
////            if (top.lChild != null)
////                stack.push(top.lChild);
////        }
////        for (TreeNode rm : rightMost.values()) {
////            sb.append(rm.value + " ");
////        }
////        return sb.toString();
////    }
//
//    private static boolean isLeaf(TreeNode node) {
//        return node.lChild == null && node.rChild == null;
//    }
//
//    private static void initBoundNodesMaps(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        int left = 1, right = 1;
//        queue.offer(root);
//        queue.offer(null);
//        while (!queue.isEmpty()) {
//            TreeNode head = queue.poll();
//            if (head == null) {
//                if (!queue.isEmpty()) {
//                    leftMost.put(left++, queue.peek());
//                    queue.offer(null);
//                }
//            } else {
//                if (queue.peek() == null)
//                    rightMost.put(right++, head);
//                if (head.lChild != null)
//                    queue.offer(head.lChild);
//                if (head.rChild != null)
//                    queue.offer(head.rChild);
//            }
//        }
//        leftMost.put(0, root);
//        rightMost.remove(1);
//        return;
//    }

//    -------------------------fail----------------------------------------
//    private enum Bound {
//        LEFTMOST, RIGHTMOST
//    }
//
//    public static String _Standard1(TreeNode root) {
//        HashMap<TreeNode, Bound> leftRightMost = getLeftRightMostNodes(root);
//        for (TreeNode node : leftRightMost.keySet()) {
//            if (leftRightMost.get(node) == Bound.RIGHTMOST)
//                System.out.println(node.value);
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<TreeNode> rightMost = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode top = stack.pop();
//            if ((!leftRightMost.containsKey(top) || leftRightMost.get(top) != Bound.RIGHTMOST) && top.lChild == null && top.rChild == null || leftRightMost.containsKey(top) && leftRightMost.get(top) == Bound.LEFTMOST)
//                sb.append(top.value + " ");
//            else if (leftRightMost.containsKey(top) && leftRightMost.get(top) == Bound.RIGHTMOST)
//                rightMost.push(top);
//            if (top.rChild != null)
//                stack.push(top.rChild);
//            if (top.lChild != null)
//                stack.push(top.lChild);
//        }
//        for (TreeNode node : rightMost)
//            sb.append(node.value + " ");
//        return sb.toString();
//    }
//
//    private static HashMap<TreeNode, Bound> getLeftRightMostNodes(TreeNode root) {
//        HashMap<TreeNode, Bound> hashMap = new HashMap<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        queue.offer(null);
//        while (!queue.isEmpty()) {
//            TreeNode head = queue.poll();
//            if (head == null) {
//                if (!queue.isEmpty()) {
//                    hashMap.put(queue.peek(), Bound.LEFTMOST);
//                    queue.offer(null);
//                }
//            } else {
//                if (queue.peek() == null)
//                    hashMap.put(head, Bound.RIGHTMOST);
//                if (head.lChild != null)
//                    queue.offer(head.lChild);
//                if (head.rChild != null)
//                    queue.offer(head.rChild);
//            }
//        }
//        hashMap.put(root, Bound.LEFTMOST);
//        return hashMap;
//    }
}
