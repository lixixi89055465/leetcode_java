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
            if (n2.next == null || n2.next.next == null)
                return null;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n2 != n1) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == head2) {
            return head1;
        }
        Node n1 = head1, n2 = head2;
        int size1 = 0, size2 = 0;
        while (n1 != null) {
            n1 = n1.next;
            size1++;
        }
        while (n2 != null) {
            n2 = n2.next;
            size2++;
        }
        Node low = null, high = null;
        if (size1 < size2) {
            low = head1;
            high = head2;
        } else {
            low = head2;
            high = head1;
        }
        int size0 = Math.abs(size1 - size2);
        for (int i = 0; i < size0; i++) {
            high = high.next;
        }
        while (low != high && low != null && high != null) {
            low = low.next;
            high = high.next;
        }
        return low;
    }
}
