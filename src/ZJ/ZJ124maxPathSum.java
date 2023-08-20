package ZJ;

public class ZJ124maxPathSum {
    public static class TreeNode {
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
        private static class MaxPath {
            public int topMax;
            public int realMax;

            public MaxPath(int topMax, int realMax) {
                this.topMax = topMax;
                this.realMax = realMax;
            }
        }

        public int maxPathSum(TreeNode root) {
            MaxPath res = dfs(root);
            return res.realMax;
        }

        private MaxPath dfs(TreeNode root) {
            if (root == null) {
                return new MaxPath(Integer.MIN_VALUE, Integer.MIN_VALUE);
            }
            MaxPath leftPath = dfs(root.left);
            MaxPath rightPath = dfs(root.right);
            int topMax = root.val;
            topMax += Math.max(0, Math.max(leftPath.topMax, rightPath.topMax));
            int realMax = root.val;
            if (leftPath.topMax > 0) {
                realMax += leftPath.topMax;
            }
            if (rightPath.topMax > 0) {
                realMax += rightPath.topMax;
            }
            realMax = Math.max(realMax,
                    Math.max(leftPath.realMax, rightPath.realMax)
            );
            return new MaxPath(topMax, realMax);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-10, new TreeNode(9, null, null),
//                new TreeNode(20, new TreeNode(15, null, null),
//                        new TreeNode(7, null, null))
//        );


    }
}
