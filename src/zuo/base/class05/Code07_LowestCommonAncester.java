package zuo.base.class05;

import java.util.HashMap;

public class Code07_LowestCommonAncester {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node lca(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lca(head.left, o1, o2);
        Node right = lca(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
}
