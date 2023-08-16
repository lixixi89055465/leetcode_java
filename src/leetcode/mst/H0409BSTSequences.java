package leetcode.mst;

import java.util.*;

/**
 * BSTSequences
 * 面试题 04.09. 二叉搜索树序列
 * 提示
 * 困难
 * 114
 * 相关企业
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * <p>
 * 给定一个由不同节点组成的二叉搜索树 root，输出所有可能生成此树的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3]
 * 输出: [[2,1,3],[2,3,1]]
 * 解释: 数组 [2,1,3]、[2,3,1] 均可以通过从左向右遍历元素插入树中形成以下二叉搜索树
 * 2
 * / \
 * 1  3
 * 示例 2:
 * <p>
 * 输入: root = [4,1,null,null,3,2]
 * 输出: [[4,1,3,2]]
 * <p>      4
 * 1
 * <p>
 * 3
 * <p>
 * 提示：
 * <p>
 * 二叉搜索树中的节点数在 [0, 1000] 的范围内
 * 1 <= 节点值 <= 10^6
 * 用例保证符合要求的数组数量不超过 5000
 */
public class H0409BSTSequences {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public List<List<Integer>> BSTSequences(TreeNode root) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                res.add(new ArrayList<>());
                return res;
            }
            ArrayList<TreeNode> deque = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            deque.add(root);
            dfs(res, root, deque, stack);
            return res;
        }

        private void dfs(ArrayList<List<Integer>> res, TreeNode root, ArrayList<TreeNode> deque, Stack<Integer> stack) {
            stack.add(root.val);
            if (deque.size() == 0) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(new Integer[stack.size()-1]));
                Collections.copy(tmp, stack.subList(1,stack.size()));
                res.add(tmp);
                stack.pop();
                return;
            }
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.get(i);
                ArrayList<TreeNode> nextDeque = new ArrayList<TreeNode>(Arrays.asList(new TreeNode[deque.size()]));
                Collections.copy(nextDeque, deque);
                nextDeque.remove(i);
                if (cur.left != null) {
                    nextDeque.add(cur.left);
                }
                if (cur.right != null) {
                    nextDeque.add(cur.right);
                }
                dfs(res, cur, nextDeque, stack);
            }
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        //root = [2,1,3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

//        root = [4,1,null,null,3,2]
//        TreeNode root = new TreeNode(4);
//        root.left=

        List<List<Integer>> res = solve.BSTSequences(root);
        System.out.println(res);
    }
}
