package leetcode.a3200;

/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 3201. 找出有效子序列的最大长度 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：
 * <p>
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
 * 返回 nums 的 最长的有效子序列 的长度。
 * //
 * // 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3,4]
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 2, 3, 4]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,1,1,2,1,2]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 2, 1, 2, 1, 2]。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1,3]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 3]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2 * 105
 * 1 <= nums[i] <= 107
 */
public class M3201 {
    public int maximumLength(int[] nums) {
        int s0 = 0, s1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                s0++;
            } else {
                s1++;
            }
        }
        int res = s1 > s0 ? s1 : s0;
        int pre = nums[0];
        int mRes = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] + pre) % 2 == 1) {
                mRes++;
                pre = nums[i];
            }
        }
        return mRes > res ? mRes : res;
    }

    public static void main(String[] args) {
        int[]nums = {1,2,1,1,2,1,2};
        M3201 s = new M3201();
        int res = s.maximumLength(nums);
        System.out.println(res);
    }
}
