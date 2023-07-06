package zuo.intermediate.class06;

import java.util.TreeMap;

public class Problem01_GetFolderTree {

    public static class Node {
        public String name;
        public TreeMap<String, Node> nextMap;

        public Node(String name) {
            this.name = name;
            this.nextMap = new TreeMap<>();
        }
    }

    public static void print(String[] folderPaths) {
        if (folderPaths == null || folderPaths.length == 0) {
            return;
        }
        Node head = generateFolderTree(folderPaths);
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static Node generateFolderTree(String[] folderPaths) {
        Node head = new Node("");
        for (int i = 0; i < folderPaths.length; i++) {
            Node cur = head;
            String[] paths = folderPaths[i].split("\\\\");
            for (int j = 0; j < paths.length; j++) {
                if (!cur.nextMap.containsKey(paths[j])) {
                    cur.nextMap.put(paths[j], new Node(paths[j]));
                }
                cur = cur.nextMap.get(paths[j]);
            }
        }
        return head;
    }


    public static void main(String[] args) {
        String test = "HJ93\\b\\c";
        System.out.println(test);
        String[] folderPaths = {"HJ93\\b\\c", "HJ93\\d\\e", "b\\csd", "d\\"};
        print(folderPaths);
        System.out.println("==================");
    }
}
