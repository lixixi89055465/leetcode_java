package zuo.base.class05;

public class Code09_SerializeAndreconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String left = serialByPre(head.left);
        String right = serialByPre(head.right);
        String res = head.value + "" + left + right;
        return res;
    }
}
