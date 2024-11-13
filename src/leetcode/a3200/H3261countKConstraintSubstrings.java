package leetcode.a3200;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/11/13 8:52
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 3261. 统计满足 K 约束的子字符串数量 II
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * <p>
 * 另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。
 * <p>
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * <p>
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的
 * 子字符串
 * 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0001111", k = 2, queries = [[0,6]]
 * <p>
 * 输出：[26]
 * <p>
 * 解释：
 * <p>
 * 对于查询 [0, 6]， s[0..6] = "0001111" 的所有子字符串中，除 s[0..5] = "000111" 和 s[0..6] = "0001111" 外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "010101", k = 1, queries = [[0,5],[1,4],[2,3]]
 * <p>
 * 输出：[15,9,3]
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，长度大于 3 的子字符串都不满足 k 约束。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 是 '0' 或 '1'
 * 1 <= k <= s.length
 * 1 <= queries.length <= 105
 * queries[i] == [li, ri]
 * 0 <= li <= ri < s.length
 * 所有查询互不相同
 * 统计满足 K 约束的子字符串数量 II
 *
 * 力扣官方题解
 * 2316
 * 2024.11.04
 * 发布于 未知归属地
 * 字符串
 * 滑动窗口
 * C
 * C++
 * 7+
 * 方法一：滑动窗口 + 前缀数组
 * 思路与算法
 *
 * 我们使用「滑动窗口」的技巧。
 * 首先，我们枚举每一个子字符串结束位置 j，更新子字符串 0 和 1 的数量统计。如果当前子字符串不再满足 k 约束，则对于当前左端点 i，字符串的右端点在 j 开始不符合 k 约束，我们记录 right[i]=j。然后我们向右移动左端点，重复这个过程直到子字符串满足 k 约束。
 *
 * 此时子字符串长度为 j−i+1，以位置 j 结束的子字符串，小于等于这个长度都满足 k 约束，我们更新前缀数组，用于计算滑动窗口找到的子字符串数量的前缀和。
 *
 * 对于每一个查询 [l,r]， 我们分为两部分：
 *
 * 右端点在 i=right[l] 之前的子字符串全都满足 k 约束， 总共数量为 (i−l+1)∗(i−l)/2。
 * 右端点在 i 及其之后的子字符串, 我们用前缀数组计算，数量为 prefix[r+1]−prefix[i]。
 * 两部分相加即为查询结果，最后返回所有查询的结果。
 */
public class H3261countKConstraintSubstrings {
    private static class Solution {
        public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {

            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "010101";
        int k = 1;
        int[][] queries = {{0, 5}, {1, 4}, {2, 3}};
        long[] res = solution.countKConstraintSubstrings(s, k, queries);
        System.out.println(res);

    }
}
