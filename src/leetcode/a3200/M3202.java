package leetcode.a3200;

/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 3202. 找出有效子序列的最大长度 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个 正 整数 k 。
 * nums 的一个 子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ：
 * <p>
 * (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k
 * 返回 nums 的 最长有效子序列 的长度。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5], k = 2
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 最长有效子序列是 [1, 2, 3, 4, 5] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,2,3,1,4], k = 3
 * 1,1,2,0,1,1
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 最长有效子序列是 [1, 4, 1, 4] 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 103
 * 1 <= nums[i] <= 107
 * 1 <= k <= 103
 */
public class M3202 {
    public int maximumLength1(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res=Math.max(res,dp[prev][num]);
            }
        }
        return res;
    }

    public int maximumLength(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] %= k;
        }
        int[][] dp = new int[nums.length][k];
        int[] preK = new int[k];
        for (int i = 0; i < k; i++) {
            preK[i] = -1;
            dp[0][i] = 1;
        }
        preK[nums[0]] = 0;
        dp[0][nums[0]] = 1;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int[] karr = dp[i];
            int cur = nums[i];
            for (int j = 0; j < k; j++) {
                int preJ = preK[j];
                if (preJ < 0) {
                    karr[j] = 1;
                } else {
                    int[] preArr = dp[preJ];
                    karr[j] = preArr[cur] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
            preK[nums[i]] = i;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 4, 2, 3, 1, 4};
//        int k = 3;//4
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;

        M3202 s = new M3202();
        int res = s.maximumLength(nums, k);
        System.out.println(res);
    }
}
