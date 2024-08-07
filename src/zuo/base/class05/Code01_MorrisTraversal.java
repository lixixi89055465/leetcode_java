package zuo.base.class05;


public class Code01_MorrisTraversal {
    class Node {
        public Node left;
        public Node right;
        int v;
    }

    public static void morrisPos(Node head) {
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }

    }

    public static void printEdge(Node X) {
        Node tail = reverseEdge(X);
        Node cur = tail;
        while (cur != null) {
            System.out.println(cur + "\t");
            cur = cur.right;
        }
        reverseEdge(X);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.v);
            cur = cur.right;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Node cur = head;
        Node mostRight = null;
        int preValue = Integer.MIN_VALUE;
        while (cur != null) {
            preValue = cur.v;
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (preValue >= cur.v) {
                return false;
            }
            preValue = cur.v;
            cur = cur.right;
        }
        return true;
    }
}

