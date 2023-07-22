package ZJ;

public class ZJ105buildTree {
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
        public TreeNode generateTree(int[] preorder, int[] inorder, int pL, int pR, int iL, int iR) {
            if (pL > pR) {
                return null;
            }
            TreeNode curNode = new TreeNode(preorder[pL]);
            int pos = iL;
            for (int i = iL; i <= iR; i++) {
                if (inorder[i] == curNode.val) {
                    pos = i;
                    break;
                }
            }
            curNode.left = generateTree(preorder, inorder, pL + 1, pL + pos - iL, iL, pos - 1);
            curNode.right = generateTree(preorder, inorder, pL + pos - iL + 1, pR, pos + 1, iR);
            return curNode;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return this.generateTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Solution solve = new Solution();
        TreeNode treeNode = solve.buildTree(preorder, inorder);
        System.out.println(treeNode.val);
    }
}
