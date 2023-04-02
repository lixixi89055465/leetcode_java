package zuo.base.class06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code01_BFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> sets = new HashSet<>();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!sets.contains(next)) {
                    sets.add(next);
                    queue.add(next);
                }
            }
        }

    }
}
