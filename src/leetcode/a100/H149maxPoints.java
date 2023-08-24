package leetcode.a100;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 * 困难
 * 505
 * 相关企业
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 */
public class H149maxPoints {
    private static class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            int res = 1;
            for (int i = 0; i < n; i++) {
                Map<Double, Integer> lineCount = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    Double xielv = 0.0;
                    if (points[i][0] != points[j][0]) {
                        xielv = 1.0 * (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                    } else {
                        xielv = Double.MAX_VALUE;
                    }
                    lineCount.put(xielv, lineCount.getOrDefault(xielv, 1) + 1);
                    res = Math.max(res, lineCount.get(xielv));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        Solution solve = new Solution();
        int res = solve.maxPoints(points);
        System.out.println(res);
    }
}
