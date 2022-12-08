package test;

public class test01 {
    protected static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteMultipleOf3(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        while (p != null) {
            if (p.val % 3 == 0) {
                p = p.next;
                continue;
            }
            break;
        }
        head = p;
        while (p!=null && p.next != null) {
            if (p.next.val % 3 == 0) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        ListNode listNode = deleteMultipleOf3(head);
        System.out.println(listNode);
    }
}
