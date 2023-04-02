package zuo.base.class05;

public class TestBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
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
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }

    private static void inOrderUnRecur(Node head) {
        System.out.println("in-order :  ");

    }
}
