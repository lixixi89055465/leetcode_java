package leetcode.mst;

/**
 * @PackageName:leetcode.mst
 * @Date 2023/8/24 10:42
 * @Description: https://leetcode.cn/problems/number-of-2s-in-range-lcci/?envType=list&envId=zbqdhrv
 * 面试题 17.06. 2出现的次数
 * 提示
 * 困难
 * 79
 * 相关企业
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * <p>
 * 示例:
 * <p>
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 * <p>
 * n <= 10^9
 * 10  1
 * 100   20
 * 1000  200
 */
public class H1706numberOf2sInRange {
    private static class Solution {
        public int numberOf2sInRange(int n) {
            int cur = 0;
            int step = 0;
            int res = 0;
            int twoNum = 0;
            int pre = 0;
            while (n > 0) {
                cur = n % 10;
                n /= 10;
                int i = 0;
                for (; i  < cur; i++) {
                    res += twoNum;
                    if (i == 2) {
                        res += Math.pow(10, step);
                    }
                }
                if (i == 2) {
                    res = res + pre + 1;
                }
                pre += cur * Math.pow(10, step);
                step += 1;
                twoNum = getTwonum(twoNum, step);
            }
            return res;
        }

        private int getTwonum(int twoNum, int step) {
            return (int) (twoNum * 10 + Math.pow(10, step-1));
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int n = 26;
//        int n = 30;
//        int n = 31;
//        int n = 1;
//        int n = 2;
        int n = 3;
        int res = solve.numberOf2sInRange(n);
        System.out.println(res);
    }
}
