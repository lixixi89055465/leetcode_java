package CF;

/**
 * @PackageName:CF
 * @Date 2023/9/27 18:31
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        int maxn = 100;
        int[][] f = new int[maxn + 1][20];
        int n = maxn;
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j + (1 << i) - 1 <= n; j++) {
                f[j][i]=Math.max(f[j][i-1],f[j-(1<<(i-1))][i-1]);
            }

        }

    }
}
