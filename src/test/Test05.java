package test;

/**
 * @author lixiang
 * data 2023/7/19
 */
public class Test05 {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head1 = l1, head2 = l2;
            ListNode head = new ListNode(0);
            ListNode cur = head;
            int pre = 0;
            while (head1 != null || head2 != null) {
                int s = (head1 != null ? head1.val : 0) + (head2 != null ? head2.val : 0) + pre;
                if (s > 10) {
                    pre = 1;
                } else {
                    pre = 0;
                }
                if (head1 != null) {
                    head1 = head1.next;
                }
                if (head2 != null) {
                    head2 = head2.next;
                }
                cur.next = new ListNode(s % 10);
                cur = cur.next;
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
//        l1 = [2,4,3], l2 = [5,6,4]
//[7,0,8]
    }
}
