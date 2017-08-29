package ArrayAndMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindNumInSortedRowsAndColsTest {
    @Test
    public void findNumInSortedRowsAndCols() throws Exception {
        int[][] matrix = new int[][]{{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
        assertEquals(true, FindNumInSortedRowsAndCols.findNumInSortedRowsAndCols(matrix, 7));
        assertEquals(false, FindNumInSortedRowsAndCols.findNumInSortedRowsAndCols(matrix, 6));
    }

}