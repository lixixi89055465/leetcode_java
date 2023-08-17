package leetcode.mst;

import java.util.*;

/**
 * 面试题 08.13. 堆箱子
 * 提示
 * 困难
 * 87
 * 相关企业
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 * <p>
 * 输入使用数组[wi, di, hi]表示每个箱子。
 * <p>
 * 示例1:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 * 示例2:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * 提示:
 * <p>
 * 箱子的数目不大于3000个。
 */
public class H0813pileBox {
    private static class Solution {

        public int pileBox(int[][] box) {
            int n = box.length;
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (box[i][0] < box[j][0] && box[i][1] < box[j][1] && box[i][2] < box[j][2]) {
                        List<Integer> jNext = map.getOrDefault(j, new ArrayList<Integer>());
                        jNext.add(i);
                        map.put(j, jNext);
                    }
                    if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                        List<Integer> iNext = map.getOrDefault(i, new ArrayList<Integer>());
                        iNext.add(j);
                        map.put(i, iNext);
                    }
                }
            }
            int res = 0;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dfs(map, i,  box, dp));
            }
            return res;
        }

        private int dfs(HashMap<Integer, List<Integer>> map, int value, int[][] box, int[] dp) {
            if (dp[value] > 0) {
                return dp[value];
            }
//            stack += box[value][2];
            int maxStack = 0;
            if (map.containsKey(value) && map.get(value).size() > 0) {
                for (Integer nextValue : map.get(value)) {
                    maxStack = Math.max(maxStack, dfs(map, nextValue, box, dp));
                }
            }
            dp[value] = maxStack + box[value][2];
            return dp[value];
        }
    }

    public static void main(String[] args) {
//        int[][] box = {{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}};
//        int[][] box = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] box = {{9, 9, 10}, {8, 10, 9}, {9, 8, 10}, {9, 8, 10}, {10, 8, 8}, {9, 8, 9}, {9, 8, 8}, {8, 9, 10}, {10, 9, 10}, {8, 8, 10}, {10, 9, 10}, {10, 9, 8}, {8, 9, 9}, {9, 10, 8}, {8, 9, 9}, {10, 10, 9}, {8, 9, 10}, {8, 10, 10}, {8, 9, 10}, {10, 10, 8}, {10, 10, 9}, {9, 10, 10}, {10, 8, 9}, {10, 10, 9}, {8, 9, 10}, {8, 8, 9}, {8, 10, 10}, {9, 9, 10}, {10, 8, 8}, {10, 10, 8}, {8, 9, 9}, {8, 9, 8}, {10, 10, 8}, {8, 10, 8}, {10, 9, 10}, {9, 9, 10}, {9, 9, 9}, {8, 9, 8}, {9, 8, 8}, {8, 9, 10}, {10, 10, 8}, {9, 9, 9}, {10, 10, 10}, {10, 9, 8}, {9, 8, 9}, {8, 8, 10}, {8, 8, 8}, {8, 8, 8}, {8, 9, 10}, {10, 9, 8}, {8, 10, 8}, {8, 10, 10}, {9, 10, 10}, {8, 8, 9}, {9, 9, 9}, {10, 8, 8}, {8, 10, 10}, {9, 10, 9}, {9, 9, 8}, {8, 10, 9}, {9, 8, 8}, {9, 9, 10}, {9, 10, 10}, {8, 8, 10}};
        Solution solve = new Solution();
        System.out.println(solve.pileBox(box));
    }
}
