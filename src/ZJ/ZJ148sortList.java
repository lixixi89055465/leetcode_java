package ZJ;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class ZJ148sortList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static class Solution {
        public ListNode sortList(ListNode head) {

            ListNode cur = head;
            int hlen = 0;
            while (cur != null) {
                cur = cur.next;
                hlen += 1;
            }
            ListNode tmp = dfs(head, hlen);

            return tmp;
        }

        private ListNode dfs(ListNode head, int hlen) {
            if (hlen <= 1) {
                return head;
            }
            int half = hlen / 2;
            ListNode half1=head;
            ListNode half2=null;
            int len=half;
            while (len> 0) {
                len-= 1;
                head = head.next;
            }
            half2=head;
            half1 = dfs(half1, half);
            half2 = dfs(half2, hlen - half);
            return mergetList(half1, half2, half, hlen - half);
        }

        private ListNode mergetList(ListNode cur1, ListNode cur2, int len1, int len2) {
            ListNode lastNode = cur2.next;
            ListNode head = null;
            if (cur1.val > cur2.val) {
                head = cur2;
                cur2 = cur2.next;
                len2-=1;
            } else {
                head = cur1;
                cur1 = cur1.next;
                len1-=1;
            }
            ListNode preNode = head;
            while (len1 > 0 && len2 > 0) {
                if (cur1.val > cur2.val) {
                    preNode.next = cur2;
                    preNode = cur2;
                    cur2 = cur2.next;
                    len2 -= 1;
                } else {
                    preNode.next = cur1;
                    preNode = cur1;
                    cur1 = cur1.next;
                    len1 -= 1;
                }
            }
            while (len1 > 0) {
                preNode.next = cur1;
                cur1=cur1.next;
                preNode = preNode.next;
                len1-=1;
            }
            while (len2 > 0) {
                preNode.next = cur2;
                cur2=cur2.next;
                preNode = preNode.next;
                len2-=1;
            }
            preNode.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        ListNode n_1 = new ListNode(1, null);
        ListNode n5 = new ListNode(2, null);
        ListNode n3 = new ListNode(3, null);
        ListNode n4 = new ListNode(4, null);
//        ListNode n0 = new ListNode(0, null);
//        n_1.next=null;
        n_1.next = n5;
        n5.next = n3;
        n3.next = n4;
//        n4.next = n0;
//        n0.next = null;

        ListNode res = solve.sortList(n_1);
//        ListNode minDistance = solve.sortList(null);
        System.out.println(res);
    }
}
