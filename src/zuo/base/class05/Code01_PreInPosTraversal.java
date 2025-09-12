package zuo.base.class05;


import netscape.security.UserTarget;

import java.util.Stack;

public class Code01_PreInPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            System.out.println();
        }
    }

    public static void inOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> s = new Stack<>();
            while (!s.isEmpty() || head != null) {
                if (head != null) {
                    s.push(head);
                    head=head.left;
                }else {
                    head = s.pop();
                    System.out.println(head.value);
                    head=head.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur1(Node head) {

    }

    public static void posOrderUnRecur2(Node head) {
        if (head != null) {
            Stack<Node> stack01 = new Stack<>();
            Stack<Node> stack02 = new Stack<>();
            stack01.push(head);
            while (!stack01.isEmpty()) {
                head = stack01.pop();
                stack02.push(head);
                if (head.left != null) {
                    stack01.push(head.left);
                }
                if (head.right != null) {
                    stack01.push(head.right);
                }
            }
            while (!stack02.isEmpty()) {
                System.out.println(stack02.pop());
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);

    }

}
