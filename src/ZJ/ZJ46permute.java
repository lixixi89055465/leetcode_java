package ZJ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZJ46permute {
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

        private void dfs(List<List<Integer>> res, Integer[] nums, int index) {
            if (index == nums.length - 1) {
                ArrayList<Integer> integers = new ArrayList<>(nums.length);
                Collections.addAll(integers, nums);
                res.add(integers);
                return;
            }

            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                dfs(res, nums, index + 1);
                swap(nums, index, i);
            }

        }

        private void swap(Integer[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solve.permute(nums));

    }
}
