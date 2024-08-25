package zuo.intermediate.class01;

/**
 * 给定一个非负整数n，代表二叉树的节点个数。返回能形成多少种不同的二叉树结构
 */
public class Problem06_UniqueBST {
    public static int process(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = process(i);
            int right = process(n - 1 - i);
            res += left * right;
        }
        return res;
    }

    public static int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {


    }
}
