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

    public static void print(String[] folderpaths) {
        if (folderpaths == null || folderpaths.length == 0) {
            return;
        }
        Node head = generateFolder(folderpaths);
        printProcess(head, 0);
    }

    private static void printProcess(Node node, int level) {
        if (level != 0) {
            System.out.println(get2nSpace(level));
        }
        for (Node next : node.nextMap.values()) {
            printProcess(next, level + 1);
        }
    }

    private static String get2nSpace(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append(",");
        }
        return sb.toString();
    }

    private static Node generateFolder(String[] folderpaths) {
        Node node = new Node("");
        for (String fold : folderpaths) {
            Node pre = node;
            String[] split = fold.split("\\\\");
            if (split != null && split.length > 0) {
                for (String s : split) {
                    if (!pre.nextMap.containsKey(s)) {
                        pre.nextMap.put(s, new Node(s));
                    }
                    pre = pre.nextMap.get(s);
                }
            }
        }
        return node;
    }

    public static void main(String[] args) {
        String[] folders = {
                "HJ93\\b\\c",
                "d\\f\\g",
                "e\\i\\h",
                "e\\i\\j",
                "e\\i\\k",
                "e\\i\\k",
        };
        print(folders);
    }


}

