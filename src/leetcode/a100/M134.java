package leetcode.a100;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月26日 11:05
 * 项目名称: leetcode_java
 * 文件名称: M134
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 * <p>
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 134. 加油站
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * <p>
 * 提示:
 * <p>
 * n == gas.length == cost.length
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 * 输入保证答案唯一。*
 *
 * @Copyright:
 */

public class M134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        int gasSum = 0;
        int costSum = 0;

        int tiao = 0;
        while (i < n) {
            gasSum += gas[(i) % n];
            costSum += cost[(i + 1) % n];
            while (tiao < n) {
                gasSum += gas[(i + tiao) % n];
                costSum += cost[(i + tiao + 1) % n];
                tiao++;
            }
            if (tiao == n) {
                return i;
            } else {
                i = i + tiao + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        M134 s = new M134();
//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cos = {3, 4, 5, 1, 2};
//        int[] gas = {2, 3, 4};
//        int[] cos = {3, 4, 3};
//        gas =[5,8,2,8]
//        cost =[6,5,6,6]
        int[] gas = {5, 8, 2, 8};
        int[] cos = {6, 5, 6, 6};
        int res = s.canCompleteCircuit(gas, cos);
        System.out.println(res);

    }
}
