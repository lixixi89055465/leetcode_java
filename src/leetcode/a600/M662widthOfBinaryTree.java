package leetcode.a600;

import java.util.ArrayDeque;

//Definition for HJ93 binary tree node.
class TreeNode662 {
    int val;
    TreeNode662 left;
    TreeNode662 right;

    TreeNode662() {
    }

    TreeNode662(int val) {
        this.val = val;
    }

    TreeNode662(int val, TreeNode662 left, TreeNode662 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution662 {

    public int widthOfBinaryTree(TreeNode662 root) {
        ArrayDeque<Object> q = new ArrayDeque<>();
        q.add(new Object[]{root, 0});
        int qlen = q.size();
        int ans = 1;
        TreeNode662 left, right;
        while (!q.isEmpty()) {
            Object[] tmp1 = (Object[]) q.pop();
            TreeNode662 node = (TreeNode662) tmp1[0];
            if (null != node.left) {
                q.add(new Object[]{node.left, (int) tmp1[1] * 2});
            }
            if (null != node.right) {
                q.add(new Object[]{node.right, (int) tmp1[1] * 2 + 1});
            }
            qlen -= 1;
            if (qlen == 0 && !q.isEmpty()) {
                qlen = q.size();
                tmp1 = (Object[]) q.peekLast();
                Object[] tmp2 = (Object[]) q.peekFirst();
                ans = Math.max(ans, (int) tmp1[1] - (int) tmp2[1] + 1);
            }
        }
        return ans;
    }
}

public class M662widthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode662 t1 = new TreeNode662(1);
        TreeNode662 t2 = new TreeNode662(5);
        TreeNode662 t3 = new TreeNode662(6);
        t1.left = t2;
        t1.right = t3;
        Solution662 solve = new Solution662();
        int result = solve.widthOfBinaryTree(t1);
        System.out.println(result);
    }
}
