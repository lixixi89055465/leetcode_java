package leetcode.top100;

import java.util.*;

/**
 * @PackageName:leetcode.top100
 * @Date 2023/8/30 18:44
 * @Description: https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 * 315. 计算右侧小于当前元素的个数
 * 困难
 * 1K
 * 相关企业
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 * <p>
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class H315countSmaller {

    private static class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            Integer[] res = new Integer[n];
            Integer[] index = new Integer[n];
            for (int i = 0; i < res.length; i++) {
                res[i] = 0;
                index[i] = i;
            }
            merge(nums, 0, n, res, index);
            return Arrays.asList(res);
        }

        private void merge(int[] nums, int start, int end, Integer[] res, Integer[] index) {
            if (start + 1 == end) {
                return;
            }
            int half = (start + end) / 2;
            merge(nums, start, half, res, index);
            merge(nums, half, end, res, index);
//            Arrays.sort(nums, start, half);
//            Arrays.sort(nums, half, end);
            int start0 = start, start1 = half;
            while (start0 < half && start1 < end) {
                if (nums[start0] <= nums[start1]) {
                    res[index[start0]] += start1 - half;
                    start0 += 1;
                } else {
                    start1 += 1;
                }
            }
            for (; start0 < half; start0++) {
                res[index[start0]] += start1 - half;
            }
            int[] tmpRes = new int[end - start];
            int[] tmpIndex = new int[end - start];
            int p = start, p0 = start, p1 = half;
            while (p0 < half && p1 < end) {
                if (nums[p0] <= nums[p1]) {
                    tmpRes[p - start] = nums[p0];
                    tmpIndex[p - start] = index[p0];
                    p0++;
                } else {
                    tmpRes[p - start] = nums[p1];
                    tmpIndex[p - start] = index[p1];
                    p1++;
                }
                p++;
            }
            for (; p0 < half; p0++) {
                tmpRes[p - start] = nums[p0];
                tmpIndex[p - start] = index[p0];
                p++;
            }
            for (; p1 < end; p1++) {
                tmpRes[p - start] = nums[p1];
                tmpIndex[p - start] = index[p1];
                p++;
            }
//            System.out.println();
            for (int i = start; i < end; i++) {
                index[i] = tmpIndex[i - start];
                nums[i] = tmpRes[i - start];
            }
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] nums = {5, 2, 6, 1};
//        int []nums = {-1};
//        int[] nums = {-1, -1};
//        int[] nums = {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        int[] nums = {1, 0, 2};
        System.out.println(solve.countSmaller(nums));

    }
}
