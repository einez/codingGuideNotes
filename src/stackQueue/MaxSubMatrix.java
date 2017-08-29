package stackQueue;

import java.util.Stack;

/**
 * Created by einez on 8/8/2017.
 */
public class MaxSubMatrix {
    public static int getMaxSubMatrixSize(int[][] matrix) {
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            heights[0][i] = matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[i][j] = matrix[i][j] == 0 ? 0 : heights[i - 1][j] + 1;
            }
        }
        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < matrix[0].length; j++) {
                while (!stack.isEmpty() && heights[i][stack.peek()] > heights[i][j]) {
                    int p = stack.pop();
                    maxSize = Math.max(maxSize, (p - (stack.isEmpty() ? 0 : stack.peek()) + 1) * heights[i][p]);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int p = stack.pop();
                maxSize = Math.max(maxSize, (p - (stack.isEmpty() ? 0 : stack.peek()) + 1) * heights[i][p]);
            }
        }
        return maxSize;
    }
}
