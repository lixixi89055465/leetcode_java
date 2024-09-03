package zuo.intermediate.class03;

/**
 * 用zigzag的方式打印矩阵，比如如下的矩阵
 * 0 1 2 3
 * 4 5 6 7
 * 8 9 10 11
 * 打印顺序为：0 1 4 8 5 2 3 6 9 10 7 11
 */
public class Problem02_ZigZagPrintmatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (ar != endR + 1) {
            printLevel(matrix, ar, ac, br, bc, fromUp);
            ar = ac == endC ? ar + 1 : ar;
            ac = ac == endC ? ac : ac + 1;
            bc = br == endR ? bc + 1 : bc;
            br = br == endR ? br : br + 1;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.println(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.println(m[dR--][dC++] + " ");
            }
        }

    }

    public static void main(String[] args) {

    }
}
