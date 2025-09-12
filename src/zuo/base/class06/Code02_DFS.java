package zuo.base.class06;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        s.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!s.isEmpty()) {
            Node cur = s.pop();
            for (Node next : cur.nexts) {
                if(!set.contains(next)){
                    set.add(next);
                    s.push(cur);
                    s.push(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

}
