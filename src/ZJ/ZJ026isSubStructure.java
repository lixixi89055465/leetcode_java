package ZJ;

public class ZJ026isSubStructure {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) && (cur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }


        private boolean cur(TreeNode a, TreeNode b) {
            if (b == null) {
                return true;
            }
            if (a == null || a.val != b.val) {
                return false;
            }
            return cur(a.left, b.left) && cur(a.right, b.right);
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        System.out.println(solve.isSubStructure(null, null));
    }
}
