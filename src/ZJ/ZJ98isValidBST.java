package ZJ;


/**
 * @author lixiang
 * data 2023/7/21
 */
public class ZJ98isValidBST {
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
        private static class Node {
            private Integer minV;
            private Integer maxV;
            private boolean isValid;

            public Node(Integer minV, Integer maxV, boolean isValid) {
                this.minV = minV;
                this.maxV = maxV;
                this.isValid = isValid;
            }

            public Node(boolean isValid) {
                this.isValid = isValid;
            }
        }


        public boolean isValidBST(TreeNode root) {
            return root != null ? check(root).isValid : true;
        }

        private Node check(TreeNode root) {
            if (root == null) {
                return null;
            }
            Node left = check(root.left);
            Node right = check(root.right);
            Integer minV = root.val;
            if (left != null) {
                if (!left.isValid || left.maxV >=root.val) {
                    return new Node(false);
                }
                minV = left.minV;
            }
            Integer maxV = root.val;
            if (right != null) {
                if (!right.isValid || right.minV <= root.val) {
                    return new Node(false);
                }
                maxV = right.maxV;
            }
            return new Node(minV, maxV, true);
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        boolean res = solve.isValidBST(null);
        System.out.println(res);
    }
}
