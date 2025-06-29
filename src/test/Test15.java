package test;

import java.util.Scanner;

public class Test15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 1474560;
        int kuai = 512;
        int count = sum / kuai;
        int N = Integer.parseInt(in.nextLine());
        int[] valueList = new int[N];
        int[] kList = new int[N];
        for (int i = 0; i < N; i++) {
            valueList[i] = Integer.parseInt(in.nextLine());
            kList[i] = valueList[i] / 512 + (valueList[i] % 512 == 0 ? 0 : 1);
        }
        int[][] dp = new int[count + 1][kList.length + 1];
        for (int i = 0; i <= count; i++) {
            for (int j = 0; j <= kList.length; j++) {
                dp[i][j]=Integer.MIN_VALUE;
            }
        }

        int res = dp(dp, valueList, kList, 0, 0, count, 0);
        System.out.println(res);
    }

    private static int dp(int[][] dp, int[] valueList, int[] kList, int index, int sCount, int maxCount, int sum) {

        if (sCount > maxCount) {
            return Integer.MIN_VALUE;
        }
        if (index == kList.length) {
            return sum;
        }
        if (dp[sCount][index] > 0) {
            return dp[sCount][index];
        }
        //使用index
        int p1 = dp(dp, valueList, kList, index + 1, sCount + kList[index], maxCount, sum + valueList[index]);
        //不使用index;
        int p2 = dp(dp, valueList, kList, index + 1, sCount, maxCount, sum);
        if (p1 == Integer.MIN_VALUE) {
            return p2;
        } else if (p2 == Integer.MIN_VALUE) {
            return p1;
        } else {
            dp[sCount][index] = Math.max(p1, p2);
            return dp[sCount][index];
        }
    }
}
