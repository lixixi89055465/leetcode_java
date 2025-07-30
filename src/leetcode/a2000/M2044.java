package leetcode.a2000;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 * <p>
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * <p>
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2]
 * 输出：7
 * 解释：[2,2,2] 的所有非空子集的按位或都可以得到 2 。总共有 23 - 1 = 7 个子集。
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1,5]
 * 输出：6
 * 解释：子集按位或可能的最大值是 7 。有 6 个子集按位或可以得到 7 ：
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 105
 */
public class M2044 {
    int[] nums;
    int maxOr, cnt;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.maxOr = 0;
        this.cnt = 0;
        dfs(0, 0);
        return cnt;
    }

    private void dfs(int pos, int orVal) {
        if (pos == this.nums.length) {
            if (orVal > maxOr) {
                maxOr = orVal;
                this.cnt = 1;
            } else if (orVal == maxOr) {
                this.cnt++;
            }
            return;
        }

        dfs(pos + 1, orVal | nums[pos]);
        dfs(pos + 1, orVal);
    }


    public static void main(String[] args) {
//        M2044 solve = new M2044();
//        int[] nums = {3, 2, 1, 5};
//        int ans = solve.countMaxOrSubsets(nums);
//        System.out.println(ans);
        String s = "100000001_1_1_10";
        String substring = "";
        if (s.indexOf("_") > 0) {
            substring = s.substring(s.indexOf("_") + 1);
        }

        System.out.println(substring);


    }
}


