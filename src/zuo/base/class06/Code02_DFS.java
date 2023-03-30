package zuo.base.class06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code02_DFS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> sets = new HashSet<>();
        stack.add(node);
        sets.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            boolean isFlag = false;
            for (Node next : cur.nexts) {
                if (!sets.contains(next)) {
                    stack.add(cur);
                    sets.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
