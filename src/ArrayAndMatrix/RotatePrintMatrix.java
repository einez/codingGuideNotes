package ArrayAndMatrix;

public class RotatePrintMatrix {
    public static String rotatePrint(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        int right = arr[0].length, bottom = arr.length, left = -1, ceiling = -1;
        int row = 0, col = 0;
        while (col < right && col > left && row < bottom && row > ceiling) {
            if (col < right) {
                while (col < right)
                    sb.append("," + arr[row][col++]);
                ceiling++;
                col--;
                row++;
            } else break;
            if (row < bottom) {
                while (row < bottom)
                    sb.append("," + arr[row++][col]);
                right--;
                row--;
                col--;
            } else break;
            if (col > left) {
                while (col > left)
                    sb.append("," + arr[row][col--]);
                bottom--;
                col++;
                row--;
            } else break;
            if (row > ceiling) {
                while (row > ceiling)
                    sb.append("," + arr[row--][col]);
                left++;
                row++;
                col++;
            } else break;
        }
        sb.replace(0, 1, "");
        return sb.toString();
    }
}
