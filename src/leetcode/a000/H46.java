package leetcode.a000;

import leetcode.a100.M120;

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
 */

public class H46 {

    private static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}

