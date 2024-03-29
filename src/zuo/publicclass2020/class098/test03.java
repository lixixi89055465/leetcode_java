package zuo.publicclass2020.class098;

import java.util.ArrayList;

// 来自微软
// 给定两个数组A和B，比如
// A = { 0, 1, 1 }
// B = { 1, 2, 3 }
// A[0] = 0, B[0] = 1，表示0到1有双向道路
// A[1] = 1, B[1] = 2，表示1到2有双向道路
// A[2] = 1, B[2] = 3，表示1到3有双向道路
// 给定数字N，编号从0~N，所以一共N+1个节点
// 题目输入一定保证所有节点都联通，并且一定没有环
// 默认办公室是0节点，其他1~N节点上，每个节点上都有一个居民
// 每天所有居民都去往0节点上班
// 所有的居民都有一辆5座的车，也都乐意和别人一起坐车
// 车不管负重是多少，只要走过一条路，就耗费1的汽油
// 比如A、B、C的居民，开着自己的车来到D居民的位置，一共耗费3的汽油
// D居民和E居民之间，假设有一条路
// 那么D居民可以接上A、B、C，4个人可以用一辆车，去往E的话，就再耗费1的汽油
// 求所有居民去办公室的路上，最少耗费多少汽油
public class test03 {

    public static int cnt = 0;

    public static int minFuel(int[] a, int[] b, int n) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < a.length; i++) {
            graph.get(a[i]).add(b[i]);
            graph.get(b[i]).add(a[i]);
        }

        int cur = 0;
        int[] dfsn = new int[n + 1];
        int[] size = new int[n + 1];
        int[] cost = new int[n + 1];
        dfs(graph, dfsn, size, cost, cur);
        return cost[0];
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int[] dfsn, int[] size, int[] cost, int cur) {
        dfsn[cur] = ++cnt;
        size[cur] = 1;
        for (Integer next : graph.get(cur)) {
            if (dfsn[next] == 0) {
                dfs(graph, dfsn, size, cost, next);
                size[cur] += size[next];
                cost[cur] += cost[next];
                cost[cur] += (size[next] + 4) / 5;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {0, 1, 1};
        int[] b1 = {1, 2, 3};
        int n1 = 3;
        System.out.println(minFuel(a1, b1, n1));

        int[] a2 = {1, 1, 1, 9, 9, 9, 9, 7, 8};
        int[] b2 = {2, 0, 3, 1, 6, 5, 4, 0, 0};
        int n2 = 9;
        System.out.println(minFuel(a2, b2, n2));
    }


}
