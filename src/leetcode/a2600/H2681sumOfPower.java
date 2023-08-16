package leetcode.a2600;

import java.util.Arrays;

/**
 * 2681. 英雄的力量
 * 提示
 * 困难
 * 138
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量 定义为：
 * <p>
 * i0 ，i1 ，... ik 表示这组英雄在数组中的下标。那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])2 * min(nums[i0],nums[i1] ... nums[ik]) 。
 * 请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 109 + 7 取余。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4]
 * 输出：141
 * 解释：
 * 第 1 组：[2] 的力量为 22 * 2 = 8 。
 * 第 2 组：[1] 的力量为 12 * 1 = 1 。
 * 第 3 组：[4] 的力量为 42 * 4 = 64 。
 * 第 4 组：[2,1] 的力量为 22 * 1 = 4 。
 * 第 5 组：[2,4] 的力量为 42 * 2 = 32 。
 * 第 6 组：[1,4] 的力量为 42 * 1 = 16 。
 * 第​ ​​​​​​7 组：[2,1,4] 的力量为 42​​​​​​​ * 1 = 16 。
 * 所有英雄组的力量之和为 8 + 1 + 64 + 4 + 32 + 16 + 16 = 141 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：7
 * 解释：总共有 7 个英雄组，每一组的力量都是 1 。所以所有英雄组的力量之和为 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1,2,3
 * 1,2,3,4
 * 首先排序，得到一个递增数组[1, 2, 4, 4, 5]，有递增特性，可以直接在遍历过程中确定最大值的平方，只需要
 * 维护对应的最小值即可：
 * dp,preSum
 * 1^2 => (1) 1
 * 2^2 => (2), (2, 1) 1+2,
 * 4^2 => (4), (4, 2), (4, 2, 1),
 * (4, 1)
 * 4^2 => (4), (4, 4), (4, 4, 2), (4, 4, 2, 1), (4, 4, 1),
 * (4, 2), (4, 2, 1), (4, 1)
 * 5^2 => (5), (5, 4), (5, 4, 4), (5, 4, 4, 2), (5, 4, 4, 2, 1), (5, 4, 4, 1), (5, 4, 2), (5, 4, 2, 1), (5, 4, 1)
 * (5, 4), (5, 4, 2), (5, 4, 2, 1), (5, 4, 1), (5, 2), (5, 2, 1), (5, 1)
 * 每个固定的最大值对应的所属区间最小值之和可以从上一个最大值对应的最小值之和推出，可以划分为当前最大值单独
 * 占据一个区间（即(x)形式），加上在上一个最大值对应的所有区间前面加上当前最大值，这部分的和就是上一个最大值
 * 对应的最小值之和，以及将上一个最大值对应的区间的最大值替换为当前最大值的情况，这部分的和是上一个最大值对应的
 * 最小值之和减去上一个最大值（因为上一个最大值的单独区间无法进行替换）
 * 整理表述为遍历到nums[i]时，对应的最大值平方一定为nums[i]^2，其对应的最小值之和为f[i]，满足一下转换：
 * f[i] = nums[i] + f[i - 1] * 2 - nums[i - 1]
 * 所求即为sum(f[i] * nums[i]^2) mod 10e9+7
 * <p>
 * class Solution {
 * public int sumOfPower(int[] nums) {
 * Arrays.sort(nums);
 * int[] dp = new int[nums.length];
 * int[] preSum = new int[nums.length + 1];
 * int res = 0, mod = 1000000007;
 * for (int i = 0; i < nums.length; i++) {
 * dp[i] = (nums[i] + preSum[i]) % mod;
 * preSum[i + 1] = (preSum[i] + dp[i]) % mod;
 * res = (int) ((res + (long) nums[i] * nums[i] % mod * dp[i]) % mod);
 * if (res < 0) {
 * res += mod;
 * }
 * }
 * return res;
 * }
 * }
 * <p>
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/power-of-heroes/solutions/2359660/ying-xiong-de-li-liang-by-leetcode-solut-9k1g/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * dp
 */
public class H2681sumOfPower {
    private static class Solution {
        public int sumOfPower(int[] nums) {
            Arrays.sort(nums);
            int exp = 1000000000 + 7;
            int[] dp = new int[nums.length];
            int[] preSum = new int[nums.length + 1];
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                dp[i] = (preSum[i] + nums[i]) % exp;
                preSum[i + 1] = (preSum[i] + dp[i]) % exp;
                res = (int)((res + (long) nums[i] * nums[i] % exp*dp[i]) % exp);
            }
            return res;
        }

        public int sumOfPower1(int[] nums) {
            Arrays.sort(nums);
            int exp = (int) Math.pow(10, 9) + 7;
            int res = 0;
            int pow2 = 1;
            long cur = 0;
            for (int len = 1; len < nums.length; len++) {
                for (int left = 0; left + len < nums.length; left++) {
                    cur = ((long) nums[left] * nums[left + len]) % exp;
                    cur = (cur * nums[left + len]) % exp;
                    cur = (cur * pow2) % exp;
                    res = (int) (res + cur) % exp;
                }
                pow2 = (pow2 * 2) % exp;
            }
            for (int i = 0; i < nums.length; i++) {
                cur = ((long) nums[i] * nums[i]) % exp;
                cur = (cur * nums[i]) % exp;
                res = (int) ((res + cur) % exp);
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1, 1, 1, 1, 1};
        //567530242
        int[] nums = {658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206};
        System.out.println(solve.sumOfPower(nums));
    }
}
