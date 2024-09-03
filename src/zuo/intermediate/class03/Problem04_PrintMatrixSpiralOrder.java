package zuo.intermediate.class03;

/**
 * 给定一个正方形矩阵，只用有限几个变量，实现矩阵中每个位置的数顺时针转动
 * 90度，比如如下的矩阵
 * 0 1 2 3
 * 4 5 6 7
 * 8 9 10 11
 * 12 13 14 15
 * 矩阵应该被调整为：
 * 12 8 4 0
 * 13 9 5 1
 * 14 10 6 2
 * 15 11 7 3
 */
public class Problem04_PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] matrix, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.println(matrix[a][i]);
            }
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.println(matrix[i][b]);
            }
        } else {
            int curC = b;
            int curR = a;
            while (curC != d) {
                System.out.println(matrix[a][curC] + " ");
                curC++;
            }
            while (curR != b) {
                System.out.println(matrix[b][curR] + " ");
                curR++;
            }
            curC = d;
            curR = c;
            while (curC != b) {
                System.out.println(matrix[c][curC]);
                curC--;
            }
            while (curR != c) {
                System.out.println(matrix[d][curR]);
                curR--;
            }
        }
    }

    public static void main(String[] args) {

    }
}
