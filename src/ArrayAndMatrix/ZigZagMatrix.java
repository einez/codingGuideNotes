package ArrayAndMatrix;

public class ZigZagMatrix {
    public static String getZigZag(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        boolean rightUp = true;
        for (int diag = 0; diag <= (matrix.length - 1) + (matrix[0].length - 1); diag++) {
            int i, j;
            if (rightUp) {
                i = Math.min(diag, matrix.length - 1);
                while (i >= 0 && i >= diag - (matrix[0].length - 1)) {
                    j = diag - i;
                    sb.append("," + matrix[i--][j]);
                }
            } else {
                i = Math.max(0, diag - (matrix[0].length - 1));
                while (i <= diag && i <= matrix.length - 1) {
                    j = diag - i;
                    sb.append("," + matrix[i++][j]);
                }
            }
            rightUp = !rightUp;
        }
        if (sb.length() > 1)
            sb.replace(0, 1, "");
        return sb.toString();
    }
}
