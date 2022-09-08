package base.chass01;

public class Code04_RotateMatrix {
    public static void rotate(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a < c) {
            rotateEdge(matrix, a++, b++, c--, d--);
        }
    }

    private static void rotateEdge(int[][] m, int a, int b, int c, int d) {
        int tmp = 0;
        for (int i = 0; i < c - a; i++) {
            tmp = m[a + i][b];
            m[a + i][b] = m[c - i][b];
            m[c - i][b] = m[c][d - i];
            m[c][d - i] = m[a + i][d];
            m[a + i][d] = m[a + i][b];
        }
    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m[0].length ; j++) {
                System.out.println(m[i][j]+" " );
            }
            System.out.println();
        }
    }
}
