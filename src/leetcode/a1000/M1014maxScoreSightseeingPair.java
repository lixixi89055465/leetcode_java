package leetcode.a1000;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/23 9:49
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 1014. 最佳观光组合
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 示例 2：
 * <p>
 * 输入：values = [1,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 */
public class M1014maxScoreSightseeingPair {
    private static class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            if (values.length < 2) {
                return 0;
            }
            int[] s1 = new int[values.length + 1];
            int[] s2 = new int[values.length + 1];
            s1[0] = values[0];
            for (int i = 1; i < values.length; i++) {
                s1[i] = (values[i] + i);
                s1[i] = Math.max(s1[i - 1], s1[i]);
            }
            s2[values.length - 1] = values[values.length - 1] - (values.length - 1);
            for (int i = values.length - 2; i >= 0; i--) {
                s2[i] = (values[i] - i);
                s2[i] = Math.max(s2[i], s2[i + 1]);
            }
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < values.length - 1; i++) {
                res = Math.max(res, s1[i] + s2[i + 1]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[] values = {8, 1, 5, 2, 6};
        int[] values = {1, 2};
        Solution solve = new Solution();
        int res = solve.maxScoreSightseeingPair(values);
        System.out.println(res);
    }
}
