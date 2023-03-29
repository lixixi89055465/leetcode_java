package zuo.base.class05;

import java.util.LinkedList;
import java.util.Queue;

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
        String res = head.value + "_" + left + right;
        return res;
    }

    public static Node reconByPreString(String preStr) {
        String[] split = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.add(s);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String poll = queue.poll();
        if (poll == "#") {
            return null;
        } else {
            Node node = new Node(Integer.valueOf(poll));
            node.left = reconPreOrder(queue);
            node.right = reconPreOrder(queue);
            return node;
        }
    }
}
