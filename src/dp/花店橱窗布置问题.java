package dp;

import sun.management.GarbageCollectionNotifInfoCompositeData;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class 花店橱窗布置问题 {
    public static void main(String[] args) {
        int[][] flow = {{7, 23, -5, -24, 16},
                {5, 21, -4, 10, 23},
                {-21, 5, -4, -20, 20}};
        int m = 3, n = 5, i = 0, j = 0, k = 0;
        int[][] dp = new int[m + 1][n + 1];

        int maxV = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            if (maxV < flow[0][i]) {
                maxV = flow[0][i];
            }
            dp[0][i] = maxV;
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (i > j) {
                    continue;
                }
                maxV = Integer.MIN_VALUE;
                for (k = j; k >= i; k--) {
                    if (maxV < flow[i][k]) {
                        maxV = flow[i][k];
                    }
                    dp[i][j] = Integer.max(dp[i][j], dp[i - 1][k-1] + maxV);
                }
            }
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}
