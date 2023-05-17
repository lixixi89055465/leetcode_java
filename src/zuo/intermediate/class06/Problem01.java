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
            System.out.println(get2nSpace(level) + node.name);
        }
        for (Node next : node.nextMap.values()) {
            printProcess(next, level + 1);
        }
    }

    private static String get2nSpace(int level) {
        String res = "";
        for (int i = 1; i < level; i++) {
            res += ",";
        }
        return res;
    }

    private static Node generateFolder(String[] folderpaths) {
        Node head = new Node("");
        for (int i = 0; i < folderpaths.length; i++) {
            Node cur = head;
            String[] paths = folderpaths[i].split("\\\\");
            for (int i1 = 0; i1 < paths.length; i1++) {
                if (!cur.nextMap.containsKey(paths[i1])) {
                    cur.nextMap.put(paths[i1], new Node(paths[i1]));
                }
                cur = cur.nextMap.get(paths[i1]);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        String[] folders = {
                "a\\b\\c",
                "d\\f\\g",
                "e\\i\\h",
                "e\\i\\j",
                "e\\i\\k",
                "e\\i\\k",
        };
        print(folders);
    }


}

