package leetcode.a600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 685. 冗余连接 II
 * 困难
 * 371
 * 相关企业
 * 在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：edges = [[1,2],[1,3],[2,3]]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * 输出：[4,1]
 * class Solution {
 *     public int[] findRedundantDirectedConnection(int[][] edges) {
 *         int n = edges.length;
 *         UnionFind uf = new UnionFind(n + 1);
 *         int[] parent = new int[n + 1];
 *         for (int i = 1; i <= n; ++i) {
 *             parent[i] = i;
 *         }
 *         int conflict = -1;
 *         int cycle = -1;
 *         for (int i = 0; i < n; ++i) {
 *             int[] edge = edges[i];
 *             int node1 = edge[0], node2 = edge[1];
 *             if (parent[node2] != node2) {
 *                 conflict = i;
 *             } else {
 *                 parent[node2] = node1;
 *                 if (uf.find(node1) == uf.find(node2)) {
 *                     cycle = i;
 *                 } else {
 *                     uf.union(node1, node2);
 *                 }
 *             }
 *         }
 *         if (conflict < 0) {
 *             int[] redundant = {edges[cycle][0], edges[cycle][1]};
 *             return redundant;
 *         } else {
 *             int[] conflictEdge = edges[conflict];
 *             if (cycle >= 0) {
 *                 int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
 *                 return redundant;
 *             } else {
 *                 int[] redundant = {conflictEdge[0], conflictEdge[1]};
 *                 return redundant;
 *             }
 *         }
 *     }
 * }
 *
 * class UnionFind {
 *     int[] ancestor;
 *
 *     public UnionFind(int n) {
 *         ancestor = new int[n];
 *         for (int i = 0; i < n; ++i) {
 *             ancestor[i] = i;
 *         }
 *     }
 *
 *     public void union(int index1, int index2) {
 *         ancestor[find(index1)] = find(index2);
 *     }
 *
 *     public int find(int index) {
 *         if (ancestor[index] != index) {
 *             ancestor[index] = find(ancestor[index]);
 *         }
 *         return ancestor[index];
 *     }
 * }
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/redundant-connection-ii/solutions/416748/rong-yu-lian-jie-ii-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class H685findRedundantDirectedConnection {
    private static class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            HashMap<Integer, Integer> father = new HashMap<>();
            int n = edges.length;
            int[] in = new int[n + 1];
            for (int i = 0; i < edges.length; i++) {
                in[edges[i][1]] += 1;
                if (in[edges[i][0]] > 1) {
                    return edges[i];
                }
            }
            for (int i = 0; i < edges.length; i++) {
                if (same(father, edges[i][0], edges[i][1])) {
                    return edges[i];
                }
                union(father, edges[i][0], edges[i][1]);
            }
            return edges[0];
        }

        private void union(HashMap<Integer, Integer> father, int left, int right) {
            father.put(right, left);
        }

        private boolean same(HashMap<Integer, Integer> father, int left, int right) {
            int f1 = findP(father, left);
            int f2 = findP(father, right);
            return f1 == f2;
        }

        private int findP(HashMap<Integer, Integer> father, int son) {
            while (father.containsKey(son)) {
                son = father.get(son);
            }
            return son;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};//2,1
        int[] res = solve.findRedundantDirectedConnection(edges);
        String collect = Arrays.stream(res).boxed().collect(Collectors.toList()).stream().map(Object::toString).collect(Collectors.joining(","));

        System.out.println(collect);
    }
}
