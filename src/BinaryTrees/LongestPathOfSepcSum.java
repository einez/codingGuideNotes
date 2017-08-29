package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class LongestPathOfSepcSum {
    public static int solutionInBook(TreeNode root, int specSum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        int maxLen = 0;
        return getSolution(root, specSum, hashMap, maxLen, 0, 1);
    }

    private static int getSolution(TreeNode root, int specSum, HashMap<Integer, Integer> hashMap, int maxLen, int preSum, int layer) {
        if (root == null)
            return maxLen;
        int curSum = preSum + root.value;
        if (hashMap.containsKey(curSum - specSum))
            maxLen = Math.max(maxLen, layer - hashMap.get(curSum - specSum));
        if (!hashMap.containsKey(curSum))
            hashMap.put(curSum, layer);
        maxLen = getSolution(root.lChild, specSum, hashMap, maxLen, curSum, layer + 1);
        maxLen = getSolution(root.rChild, specSum, hashMap, maxLen, curSum, layer + 1);
        if (layer == hashMap.get(curSum))
            hashMap.remove(curSum);
        return maxLen;
    }

    public static int getLongestPathOfSepcSum(TreeNode root, int specSum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastVisited = root;
        int maxLen = 0;
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.lChild != null && lastVisited != top.lChild && lastVisited != top.rChild) {
                stack.push(top.lChild);
                maxLen = Math.max(maxLen, getPresentMaxLen(stack.listIterator(), specSum));
            } else if (top.rChild != null && lastVisited != top.rChild) {
                stack.push(top.rChild);
                maxLen = Math.max(maxLen, getPresentMaxLen(stack.listIterator(), specSum));
            } else {
                lastVisited = stack.pop();
            }
        }
        return maxLen;
    }

    private static int getPresentMaxLen(ListIterator<TreeNode> it, int specSum) {
        while (it.hasNext())
            it.next();
        int pLen = 0, maxLen = 0, pSum = 0;
        while (it.hasPrevious()) {
            pSum += it.previous().value;
            pLen++;
            if (pSum == specSum)
                maxLen = Math.max(maxLen, pLen);
        }
        return maxLen;
    }
}
