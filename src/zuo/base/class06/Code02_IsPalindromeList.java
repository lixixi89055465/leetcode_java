package zuo.base.class06;

import java.util.Stack;

public class Code02_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            stack.pop();
            head = head.next;
        }
        return true;
    }

    //need n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (null != right) {
            stack.push(right);
            right = right.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            if (stack.pop().value != cur.value) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            if (head.value == head.next.value)
                return true;
        }
        Node cur = head.next;
        Node right = head.next.next;
        while (right.next != null && right.next.next != null) {
            cur = cur.next;
            right = right.next.next;
        }
        Node next = cur.next;
        Node nnext;
        while (next != null) {
            nnext = next.next;
            next.next = cur;
            cur = next;
            next = nnext;
        }
        while (cur != null && head != null) {
            if (cur.value != head.value) {
                return false;
            }
            cur = cur.next;
            head = head.next;
        }

        return true;


    }

}
