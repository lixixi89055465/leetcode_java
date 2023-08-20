package ZJ;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZJ199rightSideView {
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
        public List<Integer> rightSideView(TreeNode root) {
            if(root==null){
                return new ArrayList<>(0);
            }
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            int nextLen = 0;
            int curLen = 1;
            ArrayList<Integer> res = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode curNode = deque.pollFirst();
                curLen -= 1;
                if (curNode.left != null) {
                    deque.addLast(curNode.left);
                    nextLen += 1;
                }
                if (curNode.right != null) {
                    deque.addLast(curNode.right);
                    nextLen += 1;
                }
                if (curLen == 0) {
                    res.add(curNode.val);
                    curLen = nextLen;
                    nextLen = 0;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        Solution solve = new Solution();
        List<Integer> res = solve.rightSideView(root);
        System.out.println(res);

    }
}
