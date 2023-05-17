package zuo.intermediate.class06;

import java.util.TreeMap;

public class Problem02_BSTtoDoubleLinkedList {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static class Info {
        public Node start;
        public Node end;

        public Info(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Info process(Node X) {
        if (X == null) {
            return new Info(null, null);
        }
        Info leftHeadEnd = process(X.left);
        Info rightHeadEnd = process(X.right);
        if (leftHeadEnd.end != null) {
            leftHeadEnd.end.right = X;
        }
        X.left = leftHeadEnd.end;
        X.right = rightHeadEnd.start;
        if (rightHeadEnd.start != null) {
            rightHeadEnd.start.left = X;
        }
        return new Info(leftHeadEnd.start != null ? leftHeadEnd.start : X,
                rightHeadEnd.end != null ? X : rightHeadEnd.end);
    }

    public static void printBSTInOrder(Node head) {
        System.out.println("BST in - order :");
        if (head != null) {
            inOrderPrint(head);

        }
    }

    private static void inOrderPrint(Node head) {

    }
}
