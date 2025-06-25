package leetcode.a000;

import leetcode.a100.M120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月25日 16:01
 * 项目名称: leetcode_java
 * 文件名称: H46
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright: 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 46. 全排列
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * class Solution {
 * public List<List<Integer>> permute(int[] nums) {
 * List<List<Integer>> res = new ArrayList<>();
 * Integer[] inums = new Integer[nums.length];
 * for (int i = 0; i < nums.length; i++) {
 * inums[i] = nums[i];
 * }
 * dfs(res, inums, 0);
 * return res;
 * }
 * <p>
 * private void dfs(List<List<Integer>> res, Integer[] nums, int index) {
 * if (index == nums.length - 1) {
 * ArrayList<Integer> integers = new ArrayList<>(nums.length);
 * Collections.addAll(integers, nums);
 * res.add(integers);
 * return;
 * }
 * <p>
 * for (int i = index; i < nums.length; i++) {
 * swap(nums, index, i);
 * dfs(res, nums, index + 1);
 * swap(nums, index, i);
 * }
 * <p>
 * }
 * <p>
 * private void swap(Integer[] nums, int index1, int index2) {
 * int tmp = nums[index1];
 * nums[index1] = nums[index2];
 * nums[index2] = tmp;
 * }
 * }
 */

public class H46 {

    private static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Integer[] inums = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                inums[i] = nums[i];
            }
            dfs(res, inums, 0);
            return res;
        }

        public void dfs(List<List<Integer>> res, Integer[] nums, int index) {
            if (index == nums.length - 1) {
                List<Integer> list = new ArrayList<>();
                Collections.addAll(list, nums);
                res.add(list);
                return;
            }
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                dfs(res, nums, index + 1);
                swap(nums, index, i);
            }


        }

        private void swap(Integer[] nums, int i, int j) {
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}

