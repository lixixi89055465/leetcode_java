package zuo.base.class02;

import utils.LinkedUtils.*;

/**
 * 链表反转
 */
public class Code01_ReverseList {


    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head.next != null) {
            next = head.next;
            pre = head;
            head = next;
        }
        return head;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next=head.next;
            head.next=pre;
            head.pre=next;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
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
            end = end.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
//        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        Node node = reverseLinkedList(n1);
//        printLinkedList(node);
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);
        DoubleNode n5 = new DoubleNode(5);
        n1.pre = null;
        n1.next = n2;
        n2.pre = n1;
        n2.next = n3;
        n3.pre = n2;
        n3.next = n4;
        n4.pre = n3;
        n4.next = n5;
        n5.pre=n4;
        n5.next=null;
        DoubleNode head= reverseDoubleList(n1);
        printDoubleLinkedList(head);


    }
}
