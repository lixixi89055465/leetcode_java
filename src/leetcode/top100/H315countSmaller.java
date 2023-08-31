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
        private class BinaryTree {
            private int[] tree;
            private int maxLen;

            public BinaryTree(int maxLen) {
                this.maxLen = maxLen;
                this.tree = new int[this.maxLen];
            }

            private void update(int i, int x) {
                if (i > maxLen) {
                    return;
                }
                for (int pos = i; pos <= this.maxLen; pos += lowBit(pos)) {
                    tree[pos - 1] += x;
                }
            }

            public int query(int end) {
                if (end > this.maxLen || end <= 0) {
                    return 0;
                }
                int ans = 0;
                for (int pos = end; pos > 0; pos -= lowBit(pos)) {
                    ans += tree[pos - 1];
                }
                return ans;
            }
            private int lowBit(int pos) {
                return pos & (-pos);
            }
        }


        public List<Integer> countSmaller(int[] nums) {
            int maxLen = 209;
            BinaryTree btree = new BinaryTree(maxLen);
            Integer[] res = new Integer[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                nums[i] += 104;
                res[i] = btree.query(nums[i]-1);
                btree.update(nums[i], 1);
            }
            return Arrays.asList(res);
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] nums = {5, 2, 6, 1};
//        int []nums = {-1};
        int[] nums = {-1, -1};
        System.out.println(solve.countSmaller(nums));

    }
}
