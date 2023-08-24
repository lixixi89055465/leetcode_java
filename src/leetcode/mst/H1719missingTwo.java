package leetcode.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:leetcode.mst
 * @Date 2023/8/24 14:52
 * @Description: https://leetcode.cn/problems/missing-two-lcci/
 * 面试题 17.19. 消失的两个数字
 * 提示
 * 困难
 * 223
 * 相关企业
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 * <p>
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 * <p>
 * nums.length <= 30000
 */
public class H1719missingTwo {
    private static class Solution {
        public int[] missingTwo(int[] nums) {

            int n1 = 0, n2 = 0;
            int[] lasts = new int[2];
            int n = nums.length;
            for (int i = 0; i < nums.length + 2; i++) {
                int index1 = getNums(i, nums, lasts);
                int pre = -1;
                if (index1 <= 0) {
                    continue;
                }
                while (getNums(index1 - 1, nums, lasts) != index1) {
                    pre = index1;
                    index1 = getNums(index1 - 1, nums, lasts);
                    setNums(pre - 1, nums, lasts, pre);
                    if (index1 <= 0) {
                        break;
                    }
                }
            }
            int[] res = new int[2];
            int start = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    res[start++] = i + 1;
                }
            }
            for (int i = 0; i < 2; i++) {
                if (lasts[i] != nums.length + i + 1) {
                    res[start++] = nums.length + i + 1;
                }
            }
            return res;
        }

        private void setNums(int i, int[] nums, int[] lasts, int pre) {
            if (i < nums.length) {
                nums[i] = pre;
            } else {
                lasts[i - nums.length] = pre;
            }
        }

        private int getNums(int i, int[] nums, int[] lasts) {
            if (i < nums.length) {
                return nums[i];
            }
            return lasts[i - nums.length];
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3};
        int[] nums = {1};
        Solution solve = new Solution();
        int[] res = solve.missingTwo(nums);
        System.out.println(res);
    }
}
