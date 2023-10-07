package luogu.P28;

import java.util.Scanner;

/**
 * @PackageName:luogu.P28
 * @Date 2023/9/28 9:33
 * @Description:https://www.luogu.com.cn/problem/P2880
 */
public class P2880BalancedLineupG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] fmax = new int[180010][21];
        int[][] fmin = new int[180010][21];
        for (int i = 1; i <= n; i++) {
            fmax[i][0] = sc.nextInt();
            fmin[i][0] = fmax[i][0];
        }
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j + (1 << (i - 1)) <= n; j++) {
                fmax[j][i] = Math.max(fmax[j][i - 1], fmax[j + (1 << (i - 1))][i - 1]);
                fmin[j][i] = Math.min(fmin[j][i - 1], fmin[j + (1 << (i - 1))][i - 1]);
            }
        }
        for (int i = 0; i < q; i++) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            int s = (int) (Math.log(R - L + 1) / Math.log(2));
            int sMax=Math.max(fmax[L][s], fmax[R - (1 << s) + 1][s]);
            int sMin=Math.min(fmin[L][s], fmin[R - (1 << s) + 1][s]);
            System.out.println(sMax-sMin);
        }
    }
}
