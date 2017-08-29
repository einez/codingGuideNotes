package ArrayAndMatrix;

public class FindNumInSortedRowsAndCols {
    public static boolean findNumInSortedRowsAndCols(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        while (i < matrix[0].length && j >= 0) {
            if (matrix[i][j] < target)
                i++;
            else if (matrix[i][j] > target)
                j--;
            else return true;
        }
        return false;
    }
}
