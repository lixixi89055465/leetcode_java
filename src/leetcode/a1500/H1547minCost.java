package leetcode.a1500;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/11/11 13:47
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 1547. 切棍子的最小成本
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：
 * <p>
 * <p>
 * <p>
 * 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
 * <p>
 * 你可以按顺序完成切割，也可以根据需要更改切割的顺序。
 * <p>
 * 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。请参阅第一个示例以获得更直观的解释。
 * <p>
 * 返回切棍子的 最小总成本 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, cuts = [1,3,4,5]
 * 输出：16
 * 解释：按 [1, 3, 4, 5] 的顺序切割的情况如下所示：
 * <p>
 * 第一次切割长度为 7 的棍子，成本为 7 。第二次切割长度为 6 的棍子（即第一次切割得到的第二根棍子），第三次切割为长度 4 的棍子，最后切割长度为 3 的棍子。总成本为 7 + 6 + 4 + 3 = 20 。
 * 而将切割顺序重新排列为 [3, 5, 1, 4] 后，总成本 = 16（如示例图中 7 + 4 + 3 + 2 = 16）。
 * 示例 2：
 * <p>
 * 输入：n = 9, cuts = [5,6,1,4,2]
 * 输出：22
 * 解释：如果按给定的顺序切割，则总成本为 25 。总成本 <= 25 的切割顺序很多，例如，[4, 6, 5, 2, 1] 的总成本 = 22，是所有可能方案中成本最小的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10^6
 * 1 <= cuts.length <= min(n - 1, 100)
 * 1 <= cuts[i] <= n - 1
 * cuts 数组中的所有整数都 互不相同
 */
public class H1547minCost {
    private static class Solution {
        public int minCost(int n, int[] cuts) {
            int len = cuts.length;
            Arrays.sort(cuts);
            int[][] dp = new int[len + 1][len + 1];
            for (int i = 2; i < len; i++) {
                for (int j = 0; j + i < len; j++) {
                    int res = cuts[j + i] + dp[j][j + i];
                    for (int k = 1; k < i; k++) {
                        res = Math.min(res, dp[j][j + k] + dp[j + k][j + i] + cuts[i + j] - cuts[j] + 1);
                    }
                    dp[j][j + i] = res;
                }
            }
            for (int i = len - 1; i >= 0; i--) {
                int res = Integer.MAX_VALUE;
                for (int k = 1; i + k < len; k++) {
                    res = Math.min(res, dp[i][i + k] + dp[i + k][len] + n - cuts[i]);
                }
                dp[i][len] = res;
            }
            return dp[0][len - 1];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //n = 9, cuts = [5,6,1,4,2]
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};
        int res = s.minCost(n, cuts);
        System.out.println(res);
    }
}
