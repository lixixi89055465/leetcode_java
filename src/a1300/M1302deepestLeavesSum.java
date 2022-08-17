package a1300;


/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 */
class TreeNode {
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

class Solution {
    int maxLevel = -1;
    int sum = 0;

    private void dfs(TreeNode r, int level) {
        if (r == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            sum = r.val;
        } else if (level == maxLevel) {
            sum += r.val;
        }
        dfs(r.left, level + 1);
        dfs(r.right, level + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return this.sum;
    }
}

public class M1302deepestLeavesSum {
    public static void main(String[] args) {
    }
}
