package ZJ;

public class ZJ143reorderList {
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
        public void reorderList(ListNode head) {
            ListNode low = head, fast = head.next;
            while (fast != null) {
                fast = fast.next;
                if (fast == null) {
                    break;
                }
                fast = fast.next;
                low = low.next;
            }
            ListNode rightHead = reverseListNode(low.next);
            low.next = null;
            ListNode leftHead = head;
            while (rightHead != null) {
                ListNode rightNext = rightHead.next;
                ListNode leftNext = leftHead.next;
                leftHead.next = rightHead;
                rightHead.next = leftNext;
                rightHead = rightNext;
                leftHead = leftNext;
            }
        }

        private ListNode reverseListNode(ListNode next) {
            if (next == null) {
                return null;
            }
            ListNode head = new ListNode(-1, next);
            ListNode cur = next;
            next = cur.next;
            cur.next = null;
            while (next != null) {
                ListNode tmp = next.next;
                next.next = cur;
                cur = next;
                next = tmp;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        ListNode head = new ListNode(1, null);

        solve.reorderList(head);
        System.out.println(head);
    }
}
