package leetcode.a300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 310. 最小高度树
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 *
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 *
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 *
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * 示例 2：
 *
 *
 * 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * 输出：[3,4]
 *
 *
 * 提示：
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * 所有 (ai, bi) 互不相同
 * 给定的输入 保证 是一棵树，并且 不会有重复的边
 * 通过次数51,307提交次数119,146
 */
class Solution{
    public List<Integer> findMinHeightTrees(int n, int[][]edges){
        List<Integer> ans=new ArrayList<>();
        if (n==1){
            ans.add(0);
            return ans;
        }
        int []degree=new int[n];
        List<Integer>[]obj=new List[n];
        for (int i = 0; i < n; i++) {
            obj[i]=new ArrayList<Integer>();
        }
        for (int[]edge :edges){
            obj[edge[0]].add(edge[1]);
            obj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer>queue=new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if(degree[i]==1){
                queue.offer(i);
            }
        }
        int remainNodes=n;
        while (remainNodes>2){
            int sz=queue.size();
            remainNodes-=sz;
            for (int i = 0; i < sz; i++) {
                int curr=queue.poll();
                for(int v:obj[curr]){
                    degree[v]--;
                    if(degree[v]==1){
                        queue.offer(v);
                    }
                }
            }
        }
        while (!queue.isEmpty()){
            ans.add(queue.poll());
        }
        return ans;
    }
}

public class m3120findMinHeightTrees {
    public static void main(String[] args) {

    }
}