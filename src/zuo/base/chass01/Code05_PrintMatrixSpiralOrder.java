package zuo.base.chass01;

public class Code05_PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printMatrixZigZag(matrix, tR++, tC++, dR--, dC--);
        }

    }

    public static void printMatrixZigZag(int[][] m, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.println(m[a][i] + " ");
            }
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.println(m[i][b] + " ");
            }
        } else {
            int curC = b;
            int curR = a;
            while (curC != d) {
                System.out.println(m[a][curC] + " ");
                curC++;
            }
            while (curR != c) {
                System.out.println(m[curR][d] + " ");
                curR++;
            }
            while (curC != b) {
                System.out.println(m[b][curC] + " ");
                curC--;
            }
            while (curR != a) {
                System.out.println(m[curR][b] + " ");
                curR++;
            }
        }
    }
}
