package zuo.base.class05;

import java.util.LinkedList;

public class Code05_IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        Node L = null, R = null;
        boolean leaf = false;
        while (!queue.isEmpty()) {
            head = queue.poll();
            L = head.left;
            R = head.right;
            if ((leaf && (L != null || R != null)) ||
                    (L == null || R != null)) {
                return false;
            }
            if (L != null) {
                queue.add(L);
            }
            if (R != null) {
                queue.add(R);
            }
            if (L == null || R == null) {
                leaf = true;
            }
        }
        return true;
    }
}
