package leetcode.a100;


public class M142_detectCycle {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode cur = head, slow = head.next, fast = head.next.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;

    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(3);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(4);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        M142_detectCycle solve = new M142_detectCycle();
        ListNode listNode = solve.detectCycle(l0);
    }
}
