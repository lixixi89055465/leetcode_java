package leetcode.a900;

import java.util.TreeMap;

/**
 * 创建人:  @author xxxxxx
 * 创建时间:  2024年10月01日 15:06
 * 项目名称:  leetcode_java
 * 文件名称:  M983mincostTickets
 * 文件描述:  @Description:
 * 公司名称:
 * <p>
 * All rights Reserved, Designed By xxxxxx
 * 983. 最低票价
 * 中等
 * 相关标签
 * 相关企业
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有 三种不同的销售方式 ：
 * <p>
 * 一张 为期一天 的通行证售价为 costs[0] 美元；
 * 一张 为期七天 的通行证售价为 costs[1] 美元；
 * 一张 为期三十天 的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 * <p>
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 *
 * @Copyright: 2021-2024
 */
public class M983mincostTickets {
    private static class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < days.length; i++) {
                map.put(days[i], i);
            }
//            int[][] dp = new int[days.length + 1][days[days.length - 1] + 1];
            int[] dp = new int[days[days.length - 1] + 1];
            dfs(days, map, costs, 0, 0, dp);
            return ans;
        }

        private int ans = Integer.MAX_VALUE;

        private int dfs(int[] days, TreeMap<Integer, Integer> map, int[] costs,
                        int cur, int curCost, int[] dp) {
            if (curCost > ans) {
                return Integer.MAX_VALUE;
            }
            if (cur > days[days.length - 1]) {
                return dp[days[days.length - 1]];
            }
            if (dp[cur] != 0) {
                return dp[cur];
            }
            if (days[days.length - 1] <= cur) {
                ans = Math.min(ans, curCost);
            }
            if (map.ceilingKey(cur + 1) != null) {
                int d1 = dfs(days, map, costs, map.ceilingKey(cur + 1) + 29, curCost + costs[2], dp);
                int d2 = dfs(days, map, costs, map.ceilingKey(cur + 1) + 6, curCost + costs[1], dp);
                int d3 = dfs(days, map, costs, map.ceilingKey(cur + 1), curCost + costs[0], dp);
                dp[cur] = Math.min(d1, Math.min(d2, d3));
            }
            return dp[cur];
        }
    }

    public static void main(String[] args) {

//        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, costs = {2, 7, 15};
//        int[] days = {1, 4, 6, 7, 8, 20}, costs = {2, 7, 15};
        int[] days = {1, 2, 4, 5, 6, 8, 9, 10, 11, 12, 14, 15, 16, 18, 19, 21, 22, 25, 28, 29, 30, 31, 35, 36,
                37, 38, 39, 40, 41, 42, 44, 45, 47, 48, 50, 52, 54, 56, 59, 60, 62, 63, 64, 67, 68, 69, 70, 72,
                74, 76, 77, 79,
                80, 82, 83, 84, 86, 87, 91, 95, 96, 98};
        int[] costs = {5, 20, 86};
        Solution s = new Solution();
        int res = s.mincostTickets(days, costs);
        System.out.println(res);
    }
}
