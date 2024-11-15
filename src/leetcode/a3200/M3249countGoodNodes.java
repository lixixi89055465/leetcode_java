package leetcode.a3200;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/11/14 14:03
 * @description：https://leetcode.cn/problems/count-the-number-of-good-nodes/description/
 * @modifiedBy：
 * @version: 1.0
 * 3249. 统计好节点的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。
 * 给你一个长度为 n - 1 的二维整数数组 edges，
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。
 * <p>
 * 如果一个节点的所有子节点为根的子树包含的节点数相同，则认为该节点是一个 好节点。
 * <p>
 * 返回给定树中 好节点 的数量。
 * <p>
 * 子树 指的是一个节点以及它所有后代节点构成的一棵树。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
 * <p>
 * 输出：7
 * <p>
 * 说明：
 * <p>
 * <p>
 * 树的所有节点都是好节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]
 * <p>
 * 输出：6
 * <p>
 * 说明：
 * <p>
 * <p>
 * 树中有 6 个好节点。上图中已将这些节点着色。
 * <p>
 * 示例 3：
 * <p>
 * 输入：edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]
 * <p>
 * 输出：12
 * <p>
 * 解释：
 * <p>
 * <p>
 * 除了节点 9 以外其他所有节点都是好节点。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * 输入确保 edges 总表示一棵有效的树。
 */
public class M3249countGoodNodes {
    private static class Solution {
        private int res = 0;

        public int countGoodNodes(int[][] edges) {
            res = 0;
            Map<Integer, Set<Integer>> maps = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                Set<Integer> orDefault = maps.getOrDefault(edges[i][0], new HashSet<Integer>());
                Set<Integer> orDefault1 = maps.getOrDefault(edges[i][1], new HashSet<Integer>());
                orDefault.add(edges[i][1]);
                orDefault1.add(edges[i][0]);
                maps.put(edges[i][0], orDefault);
                maps.put(edges[i][1], orDefault1);
            }
            int count = dfs(maps, 0);
            return res;
        }

        private int dfs(Map<Integer, Set<Integer>> maps, int node) {
            Set<Integer> orDefault = maps.getOrDefault(node, new HashSet<>());
            int count = 1;
            if (orDefault != null && orDefault.size() > 0) {
                int pre = 0;
                int tmpRes = 0;
                for (Integer integer : orDefault) {
                    Set<Integer> integers = maps.get(integer);
                    integers.remove(node);
                    pre = dfs(maps, integer);
                    tmpRes = integer;
                    break;
                }

                boolean flag = true;
                for (Integer integer : orDefault) {
                    if (tmpRes == integer) {
                        continue;
                    }
                    Set<Integer> integers = maps.get(integer);
                    integers.remove(node);
                    int dfs1 = dfs(maps, integer);
                    count += dfs1;
                    if (dfs1 != pre) {
                        flag = false;
                    }
                }
                if (flag == true) {
                    res += 1;
                }
            } else {
                res += 1;
            }
            return count;
        }

    }

    public static void main(String[] args) {
//        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}};
        int[][] edges = {{6, 0}, {1, 0}, {5, 1}, {2, 5}, {3, 1}, {4, 3}};
        Solution solution = new Solution();
        int res = solution.countGoodNodes(edges);
        System.out.println(res);

    }
}
