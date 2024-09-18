package leetcode.a800;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/17 12:15
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 815. 公交路线
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 * <p>
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 */
public class H815numBusesToDestination {
    private static class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            Map<Integer, Set<Integer>> routeMap = new HashMap<>();
            List<Integer> startList = new ArrayList<>();
            for (int i = 0; i < routes.length; i++) {
                for (int j = 0; j < routes[i].length; j++) {
                    if (!routeMap.containsKey(routes[i][j])) {
                        routeMap.put(routes[i][j], new HashSet<>());
                    }
                    routeMap.get(routes[i][j]).add(i);
                    if (routes[i][j] == source) {
                        startList.add(i);
                    }
                }
            }
            boolean[] visit = new boolean[routes.length];
            int res = Integer.MIN_VALUE;
            for (Integer start : startList) {
                visit[start] = true;
                res = Math.min(res, dfs(routeMap, routes, visit, start, target));
                visit[start] = false;
            }
            if (res < 0) {
                return -1;
            }
            return res;
        }

        private int dfs(Map<Integer, Set<Integer>> routeMap, int[][] routes, boolean[] visit, Integer cur, int target) {
            if (!routeMap.containsKey(cur)) {
                return -1;
            }
            Set<Integer> nexts = routeMap.get(cur);
            if (nexts.contains(target)) {
                return 1;
            }
            visit[cur] = true;
            for (Integer next : nexts) {
                dfs(routeMap,routes,visit,,)
            }

            visit[cur] = true;
        }
    }

    public static void main(String[] args) {
        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        int source = 15, target = 12;
        Solution solve = new Solution();
        int res = solve.numBusesToDestination(routes, source, target);
        System.out.println(res);
    }
}
