package base.class07;

import java.util.LinkedList;
import java.util.Queue;

public class Code04_SerializeAndRecondtruct {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    private static void pres(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
            return;
        }
        pres(head.left, ans);
        pres(head.right, ans);
    }

    public static Node preb(Queue<String> prelist) {
        if (prelist.isEmpty()) {
            return null;
        }
        String value = prelist.poll();
        Node node = new Node(Integer.valueOf(value));
        node.left = preb(prelist);
        node.right = preb(prelist);
        return node;
    }

    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.left != null) {
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }
}
