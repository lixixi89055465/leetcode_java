package ZJ;

/**
 * 440. 字典序的第K小数字
 * 困难
 * 572
 * 相关企业
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 示例 2:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 1
 */
public class ZJ440findKthNumber01 {
    private static class Solution {
        public int findKthNumber(int n, int k) {
            int curr = 1;
            k--;
            while (k > 0) {
                long step = getStep(curr, n);
                if (step <= k) {
                    k -= step;
                    curr += 1;
                } else {
                    curr *= 10;
                    k -= 1;
                }
            }
            return curr;
        }

        private long getStep(int curr, int n) {
            int step = 0;
            int first = curr;
            int last = curr;
            while (curr <= n) {
                step += Math.min(last, n) - first + 1;
                first *= 10;
                last = last * 10 + 9;
            }
            return step;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int n = 13, k = 3;
//        int n = 10, k = 3;
        int n = 100, k = 90;
        int res = solve.findKthNumber(n, k);
        System.out.println(res);
    }


}
