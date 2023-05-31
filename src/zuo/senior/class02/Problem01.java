package zuo.senior.class02;


import java.util.*;

public class Problem01 {
    private static class Node {
        public int x;
        public int h;
        public boolean isAdd;

        public Node(int x, int h, boolean isAdd) {
            this.x = x;
            this.h = h;
            this.isAdd = isAdd;
        }
    }

    private static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            if (o1.isAdd != o2.isAdd) {
                return o1.isAdd ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildHeight(int[][] matrix) {
        Node[] nodes = new Node[matrix.length * 2];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i * 2] = new Node(matrix[i][0], matrix[i][1], true);
            nodes[i * 2 + 1] = new Node(matrix[i][0], matrix[i][1], false);
        }
        Arrays.sort(nodes, new NodeComparator());
        TreeMap<Integer, Integer> heightTime = new TreeMap<>();
        TreeMap<Integer, Integer> XHeight = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isAdd) {
                if (!heightTime.containsKey(nodes[i].h)) {
                    heightTime.put(nodes[i].h, 1);
                } else {
                    heightTime.put(nodes[i].h, heightTime.get(nodes[i].h) + 1);
                }
            } else {
                if (heightTime.get(nodes[i].h) == 1) {
                    heightTime.remove(nodes[i].h);
                } else {
                    heightTime.put(nodes[i].h, heightTime.get(nodes[i].h) - 1);
                }
            }
            if (heightTime.isEmpty()) {
                XHeight.put(nodes[i].x, 0);
            } else {
                XHeight.put(nodes[i].x, heightTime.lastKey());
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        int preheigt = 0;
        for (Map.Entry<Integer, Integer> entry : XHeight.entrySet()) {
            int curX = entry.getKey();
            int curMaxHeight = entry.getValue();
            if (preheigt != curMaxHeight) {
                if (preheigt != 0) {
                    result.add(new ArrayList<>(Arrays.asList(start, curX, curMaxHeight)));
                }
                start = curX;
                preheigt = curMaxHeight;
            }
        }
        return result;

    }
}
