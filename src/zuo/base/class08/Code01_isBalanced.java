package zuo.base.class08;


public class Code01_isBalanced {
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean b, int h) {
            isBalanced = b;
            height = h;
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static Info process2(Node head) {
        if (head == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(head.left);
        Info rightInfo = process2(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height);
        boolean isBalanceed = true;
        if (!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanceed = false;
        }
        return new Info(isBalanceed, height);
    }

    public static void main(String[] args) {

    }
}
