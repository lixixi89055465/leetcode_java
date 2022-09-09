package base.class10;

import java.util.*;

public class Code02_DFS {
    public static void dfs(Node graph) {
        if (graph == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        HashSet<Node> set = new HashSet<>();
        stack.push(graph);
        set.add(graph);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(cur.value);
                    break;
                }
            }
        }

    }
}
