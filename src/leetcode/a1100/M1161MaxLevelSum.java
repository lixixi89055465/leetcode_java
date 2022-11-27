package leetcode.a1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 *
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *
 *
 * 提示：
 *
 * 树中的节点数在 [1, 104]范围内
 * -105 <= Node.val <= 105
 * 通过次数25,770提交次数38,978
 */
class TreeNode {
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int val;
    public TreeNode left;
    public TreeNode right;
}

public class M1161MaxLevelSum {
    private List<Integer> sum = new ArrayList<>();
    public int maxLevelSum(TreeNode root) {
        dfs(root,0);
        int ans=0;
        for (int i = 0; i < sum.size(); i++) {
            if(sum.get(ans)<sum.get(i)){
                ans=i;
            }
        }
        return ans+1;
    }
    private void dfs(TreeNode node,int level){
        if(level==sum.size()){
            sum.add(node.val);
        }else{
            sum.set(level,node.val+sum.get(level));
        }
        if(node.left!=null) {
            dfs(node.left, level + 1);
        }
        if(node.right!=null){
            dfs(node.right,level+1);
        }
    }

    public static void main(String[] args) {
        List<Integer> root= Arrays.asList(989,null,10250,98693,-89388,null,null,null,-32127);
        TreeNode t1=new TreeNode(989);
        TreeNode t2=new TreeNode(10250);
        TreeNode t3=new TreeNode( 98693 );
        TreeNode t4=new TreeNode(-89388);
        TreeNode t5=new TreeNode(-32127);

        t1.right=t2;
        t2.left=t3;
        t2.right=t4;
        t4.right=t5;
        M1161MaxLevelSum solution=new M1161MaxLevelSum();
        int result=solution.maxLevelSum(t1);
        System.out.println(result);
    }

}
