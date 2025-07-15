package leetcode.a1200;

public class S1290 {
    private class ListNode {
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

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res *= 2;
            res += head.val;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        S1290 s = new S1290();
//        s.getDecimalValue();;

    }
}
