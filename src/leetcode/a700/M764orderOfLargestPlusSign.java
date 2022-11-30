package leetcode.a700;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 764. 最大加号标志
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * <p>
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 * <p>
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * 1 <= mines.length <= 5000
 * 0 <= xi, yi < n
 * 每一对 (xi, yi) 都 不重复
 */
public class M764orderOfLargestPlusSign {
    protected static class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            if (n == 0) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < mines.length; i++) {
                set.add(mines[i][0] * n + mines[i][1]);
            }

            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], n);
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                count = 0;
                //up
                for (int j = 0; j < n; j++) {
                    if (!set.contains(j * n + i)) {
                        count++;
                    } else {
                        count = 0;
                    }
                    dp[j][i] = Math.min(dp[j][i], count);
                }
                count = 0;
                //left
                for (int j = 0; j < n; j++) {
//                    if (mines[i][j] == 1) {
                    if (!set.contains(i * n + j)) {
                        count++;
                    } else {
                        count = 0;
                    }
                    dp[i][j] = Math.min(dp[i][j], count);
                }
            }
            for (int i = 0; i < n; i++) {
                count = 0;
                // down
                for (int j = n - 1; j >= 0; j--) {
//                    if (mines[j][i] == 1) {
                    if (!set.contains(j * n + i)) {
                        count++;
                    } else {
                        count = 0;
                    }
                    dp[j][i] = Math.min(dp[j][i], count);
                }
                //right
                count = 0;
                for (int j = n - 1; j >= 0; j--) {
//                    if (mines[i][j] == 1) {
                    if (!set.contains(i * n + j)) {
                        count++;
                    } else {
                        count = 0;
                    }
                    dp[i][j] = Math.min(dp[i][j], count);
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(dp[i][j], ans);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] mines = new int[][]{{4, 2}};
        Solution solution = new Solution();
        int result = solution.orderOfLargestPlusSign(n, mines);
        System.out.println(result);
    }
}
