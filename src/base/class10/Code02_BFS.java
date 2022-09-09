package base.class10;

import java.util.*;

public class Code02_BFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }

            }
        }

    }
}
