package leetcode.a1200;

/**
 * 1289. 下降路径最小和 II
 * 提示
 * 困难
 * 185
 * 相关企业
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * <p>
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * 示例 2：
 * <p>
 * 输入：grid = [[7]]
 * 输出：7
 * <p>
 * grid =
 * [[-73,61,43,-48,-36],[3,30,27,57,10],[96,-76,84,59,-15],[5,-49,76,31,-7],[97,91,61,-46,67]]
 * 添加到测试用例
 * 输出
 * 242
 * 预期结果
 * -192
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 */
public class H1289minFallingPathSum {
    private static class Solution {
        public int minFallingPathSum(int[][] grid) {
            if (grid.length == 1) {
                return grid[0][0];
            }
            int n = grid.length;
            int presecondSmall = Integer.MAX_VALUE, prefirstSmall = Integer.MAX_VALUE;
            prefirstSmall = grid[n - 1][0] >= grid[n - 1][1] ? 1 : 0;
            presecondSmall = grid[n - 1][0] >= grid[n - 1][1] ? 0 : 1;
            for (int i = 2; i < grid.length; i++) {
                if (grid[n - 1][i] <= grid[n - 1][prefirstSmall]) {
                    presecondSmall = prefirstSmall;
                    prefirstSmall = i;
                } else if (grid[n - 1][i] < grid[n - 1][presecondSmall]) {
                    presecondSmall = i;
                }
            }
            int firstRes = grid[n - 1][prefirstSmall], secondRes = grid[n - 1][presecondSmall];
            for (int i = grid.length - 2; i >= 0; i--) {
                int secondSmall = -1, firstSmall = -1;
                firstSmall = grid[i][0] >= grid[i][1] ? 1 : 0;
                secondSmall = grid[i][0] >= grid[i][1] ? 0 : 1;
                for (int j = 2; j < grid.length; j++) {
                    if (grid[i][j] <= grid[i][firstSmall]) {
                        secondSmall = firstSmall;
                        firstSmall = j;
                    } else if (grid[i][j] < grid[i][secondSmall]) {
                        secondSmall = j;
                    }
                }
                if (firstSmall != prefirstSmall) {
                    if (secondSmall != prefirstSmall) {
                        secondRes = firstRes + grid[i][secondSmall];
                    } else {
                        secondRes = secondRes + grid[i][secondSmall];
                    }
                    firstRes += grid[i][firstSmall];
                    prefirstSmall = firstSmall;
                    presecondSmall = secondSmall;
                } else {
                    firstRes += grid[i][secondSmall];
                    secondRes += grid[i][firstSmall];
                    prefirstSmall = firstRes <= secondRes ? secondSmall : firstSmall;
                    presecondSmall = firstRes > secondRes ? secondSmall : firstSmall;
                }
                if (firstRes > secondRes) {
                    int tmp = firstRes;
                    firstRes = secondRes;
                    secondRes = tmp;
                    tmp = firstSmall;
                    firstSmall = secondSmall;
                    secondSmall = tmp;
                }
            }
            return Math.min(firstRes, secondRes);
        }

    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//        int[][] grid = {
//                {-73, 61, 43, -48, -36},//-192
//                {3, 30, 27, 57, 10},//-126,-119
//                {96, -76, 84, 59, -15},//-129,-110
//                {5, -49, 76, 31, -7},//-95,-53
//                {97, 91, 61, -46, 67}};//-46,-46
        int[][] grid = {
                {1, 99, 99},
                {0, 2, 1},
                {99, 99, 4}};
        Solution solve = new Solution();
        System.out.println(solve.minFallingPathSum(grid));

    }
}
