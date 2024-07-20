package zuo.base.class05;

import java.util.LinkedList;

public class Code04_IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int preValue = Integer.MIN_VALUE;

    public static boolean checkBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if (!isLeftBst) {
            return false;
        }
        if (head.value < preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBst = isBST(head.left);
        if (!isLeftBst) {
            return false;
        }else{
            preValue=head.value;
        }
        return isBST(head.right);


    }

    public static void process(Node node, LinkedList<Node> inOrderList) {
        if (node == null)
            return;
    }

}
