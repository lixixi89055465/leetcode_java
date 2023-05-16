package zuo.intermediate.class06;

import java.util.TreeMap;

public class Problem01 {
    private static class Node {
        public String name;
        public TreeMap<String, Node> nextMap;

        public Node(String name) {
            this.name = name;
            this.nextMap = new TreeMap<>();
        }
    }
}

