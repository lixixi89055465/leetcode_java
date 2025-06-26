package leetcode.a500;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月26日 09:43
 * 项目名称: leetcode_java
 * 文件名称: S572
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 * <p>
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 572. 另一棵树的子树
 * 尝试过
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 *
 * @Copyright:
 */

public class S572 {
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            String s1 = tree2Str(root);
            String s2 = tree2Str(subRoot);
            return s1.contains(s2);
        }

        private String tree2Str(TreeNode root) {
            StringBuilder sb = new StringBuilder("");
            dfs(root, sb);
            return sb.toString();
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("N");
                return;
            }
            sb.append(root.val);
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
    }

    public static void main(String[] args) {

    }
}
