package zuo.base.class04;

/**
 * 两个单链表相交的一系列问题
 * 【题目】给定两个可能有环也可能无环的单链表，头节点head1和head2。请实
 * 现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返
 * 回null
 * 【要求】如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度
 * 请达到O(1)。
 */
public class Code07_FindFirstIntersectNode {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next, n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == head2) {
            return null;
        }
        Node cur1 = head1, cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            cur1 = cur1.next;
            n++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            n--;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        while (n > 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;


    }
}
