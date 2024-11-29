package leetcode.a2300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/20 18:08
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 2376. 统计特殊整数
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 * <p>
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 20
 * 输出：19
 * 解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * 解释：1 到 5 所有整数都是特殊整数。
 * 示例 3：
 * <p>
 * 输入：n = 135
 * 输出：110
 * 解释：从 1 到 135 总共有 110 个整数是特殊整数。
 * 不特殊的部分数字为：22 ，114 和 131 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 109
 */
public class H2376countSpecialNumbers {
    private static class Solution {
        public int countSpecialNumbers(int n) {
            int res = 0;
            Set<Integer> visit = new HashSet<>();
            for (int i = 1; i < 10; i++) {
                if (n >= i) {
                    visit.add(i);
                    res += dfs(i, n, visit);
                    visit.remove(i);
                }
            }
            return res;
        }

        private int dfs(int root, int n, Set<Integer> visit) {
            if (root > n) {
                return 0;
            }
            int res = 1;
            int next = 0;
            for (int i = 0; i < 10; i++) {
                if (!visit.contains(i)) {
                    next = root * 10 + i;
                    visit.add(i);
                    res += dfs(next, n, visit);
                    visit.remove(i);
                }
            }
            return res;
        }

        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

        public int countSpecialNumbers2(int n) {
            String nStr = String.valueOf(n);
            int res = 0;
            int prod = 9;
            for (int i = 0; i < nStr.length() - 1; i++) {
                res += prod;
                prod *= 9 - i;
            }
            res += dp(0, false, nStr);
            return res;
        }

        private int dp(int mask, boolean prefixSmaller, String nStr) {
            if (Integer.bitCount(mask) == nStr.length()) {
                return 1;
            }
            int key = mask * 2 + (prefixSmaller ? 1 : 0);
            if (!memo.containsKey(key)) {
                int res = 0;
                int lowerBound = mask == 0 ? 1 : 0;
                int upperBound = prefixSmaller ? 9 : nStr.charAt(Integer.bitCount(mask)) - '0';
                for (int i = lowerBound; i <= upperBound; i++) {
                    if (((mask >> i) & 1) == 0) {
                        res+=dp(mask|(1<<i),prefixSmaller||i<upperBound,nStr);
                    }
                }
                memo.put(key,res);
            }
            return memo.get(key);
        }

        public int countSpecialNumbers1(int n) {
            int res = 0;
            for (int i = 1; i <= n; i++) {
                int temp = i;
                Set<Integer> set = new HashSet();
                boolean flag = false;
                while (temp > 0) {
                    int i1 = temp % 10;
                    temp /= 10;
                    if (set.contains(i1)) {
                        flag = true;
                        break;
                    }
                    set.add(i1);
                }
                if (!flag) {
                    res += 1;
                }
                int i1 = countSpecialNumbers(i);
                if (i1 != res) {
                    System.out.println(i);
                    break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int n = 20;
//        int n = 135;

//        int n = 5;
        int n = 820486701;
//        int res = solve.countSpecialNumbers(n);
        int res1 = solve.countSpecialNumbers1(n);
//        System.out.println(res);
//        System.out.println(res1);
//        for (int i = 1; i < 100000000; i++) {
//            int i1 = solve.countSpecialNumbers(i);
//            int i2 = solve.countSpecialNumbers1(i);
//            if (i1 != i2) {
//                System.out.println(i);
//                break;
//            }
//        }
    }
}
