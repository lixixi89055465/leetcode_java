package zuo.base.chass01;

public class Code06_ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        int Ar = 0;
        int Ac = 0;
        int Br = 0;
        int Bc = 0;
        int Endr = matrix.length - 1;
        int Endc = matrix[0].length - 1;
        boolean fromUp = false;
        while (Ar != Endr + 1) {
            printLevel(matrix, Ar, Ac, Br, Bc, fromUp);
            Ar = Ac == Endc ? Ar + 1 : Ar;
            Ac = Ac == Endc ? Ac : Ac + 1;
            Bc = Br == Endr ? Bc + 1 : Bc;
            Br = Br == Endr ? Br : Br + 1;
            fromUp = !fromUp;
        }
        System.out.println();

    }

    private static void printLevel(int[][] m, int Ar, int Ac, int Br, int Bc, boolean f) {
        if (f) {
            while (Ar != Br + 1) {
                System.out.println(m[Ar++][Ac--] + "");
            }
        } else {
            while (Br != Ar - 1) {
                System.out.println(m[Br--][Bc++]);
            }
        }

    }
}
