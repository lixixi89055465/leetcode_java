package utils;

public class LinkedUtils {
    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;
        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.next;
        }
        System.out.println();
    }

}
