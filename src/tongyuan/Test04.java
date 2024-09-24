package tongyuan;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/24 20:59
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class Test04 {
    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param A   int整型一维数组
         * @param val int整型
         * @return ListNode类
         */
        public ListNode insert(int[] A, int val) {
            // write code here
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            boolean flag = true;
            for (int i = 0; i < A.length; i++) {
                if (val < A[i] && flag) {
                    cur.next = new ListNode(val);
                    cur = cur.next;
                    flag = false;
                }
                cur.next = new ListNode(A[i]);
                cur = cur.next;
            }
            if(val>A[A.length-1]){
                cur.next=new ListNode(val);
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] A = {1,  3, 4, 5, 7};
        int[] A = {1};
        int val = 2;
        ListNode res = solve.insert(A, val);
        System.out.println(res.val);

    }
}
