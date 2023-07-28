package ZJ;

import java.util.*;


/**
 * @author lixiang
 * data 2023/7/27
 * <p>
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class ZJ0039combinationSum {
    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int i = 1; i <= target; i++) {
                for (int j = 0; j < candidates.length; j++) {
                    if (i >= j && dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> stack = new LinkedList<>();
            dfs(candidates, target, dp, res, stack, 0);
            return res;
        }

        private void dfs(int[] candidates, int target, boolean[] dp, List<List<Integer>> res, LinkedList<Integer> stack, int start) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                Collections.addAll(tmp, new Integer[stack.size()]);
                Collections.copy(tmp, stack);
                res.add(tmp);
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                stack.push(candidates[i]);
                dfs(candidates, target - candidates[i], dp, res, stack, i);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
//        int[] candidates = {2, 3, 5};//[[2,2,2,2],[2,3,3],[3,5]]
//        int target = 8;
        int[] candidates = {2, 3, 6, 7};//[[2,2,3],[7]]
        int target = 7;
        Solution solve = new Solution();
        List<List<Integer>> res = solve.combinationSum(candidates, target);
        System.out.println(res);
    }
}
