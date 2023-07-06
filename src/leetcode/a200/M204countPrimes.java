package leetcode.a200;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 */
public class M204countPrimes {
    private static class Solution {
        public int countPrimes(int n) {
            if (n < 2) {
                return 0;
            }
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            ArrayList<Integer> prime = new ArrayList<>();
            for (int i = 2; i < n; i++) {
                if (isPrime[i] == 1) {
                    prime.add(i);
                }
                for (int j = 0; j < prime.size() && i * prime.get(j) < n; j++) {
                    isPrime[i * prime.get(j)] = 0;
                    if (i % prime.get(j) == 0) {
                        break;
                    }
                }
            }
            return prime.size();


        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 999983;
//        int n = 10;
        System.out.println(solution.countPrimes(n));
    }
}
