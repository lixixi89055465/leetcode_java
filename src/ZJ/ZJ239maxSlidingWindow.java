package ZJ;

import java.util.LinkedList;

/**
 * @author lixiang
 * data 2023/8/3
 * 239. 滑动窗口最大值
 * 提示
 * 困难
 * 2.4K
 * 相关企业
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class ZJ239maxSlidingWindow {
    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k > nums.length) {
                return null;
            }
            LinkedList<Integer> maxStack = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                while (!maxStack.isEmpty() && nums[maxStack.peekFirst()] <= nums[i]) {
                    maxStack.pollFirst();
                }
                maxStack.addFirst(i);
            }
            int[] res = new int[nums.length - k + 1];
            for (int i = k - 1; i < nums.length; i++) {
                while (!maxStack.isEmpty() && nums[maxStack.peekFirst()] <= nums[i]) {
                    maxStack.pollFirst();
                }
                maxStack.addFirst(i);
                if (i - maxStack.peekLast() >= k) {
                    maxStack.pollLast();
                }
                res[i - k + 1] = nums[maxStack.peekLast()];
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        int k = 4;

        Solution solve = new Solution();
        int[] res = solve.maxSlidingWindow(nums, k);
        System.out.println(res);
    }
}
