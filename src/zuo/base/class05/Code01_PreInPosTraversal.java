package zuo.base.class05;

import java.util.Stack;

public class Code01_PreInPosTraversal {
    private static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static void inOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                while (stack.peek().left != null) {
                    stack.add(stack.peek().left);
                }
                Node cur = stack.pop();
                System.out.println(cur.value);
                if (cur.right != null) {
                    stack.add(cur.right);
                }
            }

        }
    }

    public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.add(head);
            while (!s1.isEmpty()) {
                Node cur = s1.pop();
                s2.add(cur);
                System.out.println(cur.value);
                if (cur.right != null) {
                    s1.add(cur.right);
                }
                if (cur.left != null) {
                    s1.add(cur.left);
                }
            }
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().value);
            }
        }

    }

    public static void postOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stacks = new Stack<>();
            stacks.add(head);
            while (!stacks.isEmpty()) {
                Node cur = stacks.pop();
                if (cur.left != null) {
                    stacks.add(cur.left);
                }
                if (cur.right != null) {
                    stacks.add(cur.right);
                }

            }

        }
    }

    public static void main(String[] args) {

    }
}
