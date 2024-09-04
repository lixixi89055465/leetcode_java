package leetcode.a500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/4 18:54
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 554. 砖墙
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 * <p>
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * <p>
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：wall = [[1],[1],[1]]
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * n == wall.length
 * 1 <= n <= 104
 * 1 <= wall[i].length <= 104
 * 1 <= sum(wall[i].length) <= 2 * 104
 * 对于每一行 i ，sum(wall[i]) 是相同的
 * 1 <= wall[i][j] <= 231 - 1
 * [
 * [1,2,2,1],  ,1,3,5,6
 * [3,1,2],    ,3,4,6
 * [1,3,2],    ,1,4,6
 * [2,4],      ,2,6,
 * [3,1,2],    ,3,4,6
 * [1,3,1,1]]  ,1,4,5,6
 */
public class M554leastBricks {
    private static class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int sum = 0;
            for (List<Integer> list : wall) {
                sum = 0;
                for (int i = 0; i < list.size() - 1; i++) {
                    sum += list.get(i);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res = Math.max(res, entry.getValue());
            }
            return wall.size() - res;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = Arrays.asList(
                Arrays.asList(1, 2, 2, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 1, 1));
        Solution solve = new Solution();
        System.out.println(solve.leastBricks(wall));
    }
}
