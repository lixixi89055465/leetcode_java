package zuo.base.class07;

public class Code05_BobDie {
    public static String bob1(int N, int M, int i, int j, int K) {
        long all = (long) Math.pow(4, K);
        long live = process(N, M, i, j, K);
        long gcd = gcd(all, live);
        return String.valueOf((live / gcd) + "/" + (all / gcd));
    }


    public static long process(int N, int M, int row, int col, int rest) {
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        long live = process(N, M, row - 1, col, rest - 1);
        live += process(N, M, row + 1, col, rest - 1);
        live += process(N, M, row, col - 1, rest - 1);
        live += process(N, M, row, col + 1, rest - 1);
        return live;
    }

    public  static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }

}
