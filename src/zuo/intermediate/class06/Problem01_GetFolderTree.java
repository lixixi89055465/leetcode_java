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
        if (folderPaths != null || folderPaths.length == 0) {
            return;
        }
        Node head = generateFolderTree(folderPaths);
        printProcess(head, 0);
    }

    private static void printProcess(Node head, int i) {

    }

    public static Node generateFolderTree(String[] folderPaths) {
        Node head = new Node("");
        for (int i = 0; i < folderPaths.length; i++) {
            Node cur = head;
            String[] paths = folderPaths[i].split("\\\\");
            for (int j = 0; j < paths.length; j++) {
                if (!cur.nextMap.containsKey(paths[i])) {
                    cur.nextMap.put(paths[i], new Node(paths[i]));
                }
                cur = cur.nextMap.get(paths[i]);
            }
        }
        return head;
    }


    public static void main(String[] args) {
        String test = "a\\b\\c";
        System.out.println(test);
        String[] arr = test.split("\\\\");
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
