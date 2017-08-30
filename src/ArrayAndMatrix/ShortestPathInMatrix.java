package ArrayAndMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMatrix {

    public static int getShortestPathInMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        if (row < 1 || col < 1 || matrix[0][0] == 0 || matrix[row - 1][col - 1] == 0)
            return -1;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
        int[][] parent = new int[row][col];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0][0] = true;
        parent[0][0] = -1;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            int x = head / col;
            int y = head % col;
            int[][] delta = new int[][]{{0, +1}, {0, -1}, {+1, 0}, {-1, 0}};
            for (int i = 0; i < 4; i++) {
                if (x + delta[i][0] < row && x + delta[i][0] >= 0 && y + delta[i][1] < col && y + delta[i][1] >= 0 && matrix[x + delta[i][0]][y + delta[i][1]] > 0 && !visited[x + delta[i][0]][y + delta[i][1]]) {
                    queue.offer((x + delta[i][0]) * col + y + delta[i][1]);
                    visited[x + delta[i][0]][y + delta[i][1]] = true;
                    parent[x + delta[i][0]][y + delta[i][1]] = x * col + y;
                    if (x + delta[i][0] == row - 1 && y + delta[i][1] == col - 1)
                        break;
                }
            }
        }
        int pathLen = 0;
        int target = (row - 1) * col + col - 1;
        while (target != -1) {
            pathLen++;
//            System.out.println("[" + (target / col) + "]" + "[" + (target % col) + "]");
            target = parent[target / col][target % col];
        }
        return pathLen;
    }
}
