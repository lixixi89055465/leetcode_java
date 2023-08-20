package ZJ;

import java.util.*;

public class ZJ0113pathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> stack = new LinkedList<>();
            getSubSum(root, res, stack, targetSum);
            return res;
        }

        private void getSubSum(TreeNode root, List<List<Integer>> res, List<Integer> stack, int targetSum) {
            if (root == null ) {
                return;
            }
            if (targetSum == root.val && root.left == null && root.right == null) {
                stack.add(root.val);
                List<Integer> tmp = new ArrayList<>(stack.size());
                tmp.addAll(stack);
                res.add(tmp);
                stack.remove(stack.size() - 1);
                return;
            }
            stack.add(root.val);
            getSubSum(root.left, res, stack, targetSum - root.val);
            getSubSum(root.right, res, stack, targetSum - root.val);
            stack.remove(stack.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
