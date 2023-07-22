package ZJ;

/**
 * @author lixiang
 * data 2023/7/19
 */
public class ZJ0002addTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
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
                if (s >= 10) {
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
            if (pre == 1) {
                cur.next = new ListNode(1, null);
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode h2 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode h5 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        Solution solve = new Solution();
        ListNode res = solve.addTwoNumbers(h2, h5);
        System.out.println(res);

    }
}
