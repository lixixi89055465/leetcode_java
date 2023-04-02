package zuo.base.class05;

import java.util.LinkedList;
import java.util.Queue;

//二叉树是否是完全二叉树
public class Code05_isCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static boolean isCBT(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node l = null, r = null;
        boolean leaf = false;
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
