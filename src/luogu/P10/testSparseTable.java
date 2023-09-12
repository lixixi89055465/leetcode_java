package luogu.P10;

/**
 * @PackageName:luogu.P10
 * @Date 2023/9/12 14:28
 * @Description:
 */
public class testSparseTable {

    public static void main(String[] args) {
        int n=100;
        int[][]f=new int[n][21];
        for (int j = 0; j <n; j++) {
            f[j][0]=j;
        }
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j+(1<<i)-1 < n; j++) {
                f[j][i]=Math.max( f[j][i-1],f[j+(1<<i)-1][i-1]);

            }
        }
    }
}
