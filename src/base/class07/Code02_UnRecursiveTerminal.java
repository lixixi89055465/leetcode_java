package base.class07;

import java.util.Stack;

public class Code02_UnRecursiveTerminal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void pre(Node head) {
        System.out.println("pre-order");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }

        }
        System.out.println();
    }

    public static void in(Node head) {
        System.out.println("in-order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (head != null || !stack.empty()) {
                if (head.left != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }

    public static void pos(Node head) {
        System.out.println("post-order");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.add(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.right != null) {
                    s1.push(head.right);
                }
                if (head.left != null) {
                    s1.push(head.left);
                }
            }

            while (!s2.empty()) {
                System.out.println(s2.pop().value);
            }
        }
        System.out.println();
    }

    public static void pos2(Node h) {
        System.out.println("pos-order");
        if (h != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            Node c = null;
            while (!stack.empty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.println(stack.pop().value);
                    h = c;
                }
            }
        }
        System.out.println();
    }

}
