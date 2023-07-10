package ZJ;

public class ZJ129sumNumbers {

    private static class TreeNode {
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

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = dfs(root, 0);
            return res;
        }

        private int dfs(TreeNode root, int value) {
            if (root.left == null && root.right == null) {
                return value*10+root.val;
            }
            int res = 0;
            value = value * 10 + root.val;
            if (root.left != null) {
                res += dfs(root.left, value);
            }
            if (root.right != null) {
                res += dfs(root.right, value);
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        TreeNode root=new TreeNode(1,
                new TreeNode(2,null,null),
                new TreeNode(3,null,null)
        );
        int res = solve.sumNumbers(root);
        System.out.println(res);
    }
}
