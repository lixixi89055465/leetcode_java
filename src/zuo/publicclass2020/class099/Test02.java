package zuo.publicclass2020.class099;


public class Test02 {
    public static int fast1(int[] cuts, int[] poisons, int hp) {
        int sum = 0;
        for (int poison : poisons) {
            sum += poison;
        }
        int[][][] dp = new int[cuts.length + 1][hp + 1][sum + 1];

        return process1(cuts, poisons, hp, 0, 0, dp);
    }

    private static int process1(int[] cuts, int[] poisons, int resthp, int index, int poisonSum, int[][][] dp) {
        resthp -= poisonSum;
        if (resthp <= 0) {
            return index + 1;
        }
        if (index == cuts.length) {
            if (poisonSum == 0) {
                return Integer.MAX_VALUE;
            } else {
                return (cuts.length + (resthp + poisonSum - 1) / poisonSum);
            }
        }
        if (dp[index][resthp][poisonSum] > 0) {
            return dp[index][resthp][poisonSum];
        }

        if (resthp <= cuts[index]) {
            return index;
        }
        int p1 = process1(cuts, poisons, resthp - poisonSum, index + 1, poisonSum + poisons[index], dp);
        int p2 = process1(cuts, poisons, resthp - poisonSum - cuts[index], index + 1, poisonSum, dp);
        dp[index][resthp][poisonSum] = Math.min(p1, p2);
        return dp[index][resthp][poisonSum];
    }

    public static int fast2(int[] cuts, int[] poisons, int hp) {
        int L = 1;
        int R = hp + 1;
        int m = 0;
        int ans = Integer.MAX_VALUE;
        while (L <= R) {
            m = (L + (R - L) >> 1);
            if (ok(cuts, poisons, hp, m)) {
                ans = m;
                R = m - 1;
            } else {
                L = m + 1;
            }
        }
        return ans;
    }

    private static boolean ok(int[] cuts, int[] poisons, int hp, int limit) {
        int n = Math.min(cuts.length, limit);
        for (int i = 0; i < n; i++) {
            hp -= Math.max(cuts[i], poisons[i] * (n - 1 - i));
            if (hp <= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int N = 30;
//        int cutV = 20;
//        int posionV = 10;
//        int hpV = 200;
//        int testTimes = 10000;
//        System.out.println("测试开始");
//        for (int i = 0; i < testTimes; i++) {
//            int n = (int) (Math.random() * N) + 1;
//            int[] cuts = randomArray(n, cutV);
//            int[] posions = randomArray(n, posionV);
//            int hp = (int) (Math.random() * hpV) + 1;
//            int ans1 = fast1(cuts, posions, hp);
//            int ans2 = fast2(cuts, posions, hp);
//            if (ans1 != ans2) {
//                System.out.println("出错了!");
//            }
//        }
//        System.out.println("测试结束");
    }
}
