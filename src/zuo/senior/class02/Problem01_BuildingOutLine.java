package zuo.senior.class02;

import java.util.*;

public class Problem01_BuildingOutLine {
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
            if (o1.h != o2.h) {
                return o1.h - o2.h;
            }
            if (o1.isAdd != o2.isAdd) {
                return o1.isAdd ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildings(int[][] matrix) {
        Node[] nodes = new Node[matrix.length * 2];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i * 2] = new Node(matrix[i][0], matrix[i][2], true);
            nodes[i * 2 + 1] = new Node(matrix[i][1], matrix[i][2], false);
        }
        Arrays.sort(nodes, new NodeComparator());
        TreeMap<Integer, Integer> heightTimesMap = new TreeMap<>();
        TreeMap<Integer, Integer> xTimesMap = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isAdd) {
                if (!heightTimesMap.containsKey(nodes[i].h)) {
                    heightTimesMap.put(nodes[i].h, 1);
                } else {
                    heightTimesMap.put(nodes[i].h, heightTimesMap.get(nodes[i].h) + 1);
                }
            } else {
                if (heightTimesMap.get(nodes[i].h) == 1) {
                    heightTimesMap.remove(nodes[i].h);
                } else {
                    heightTimesMap.put(nodes[i].h, heightTimesMap.get(nodes[i].h) - 1);
                }
            }
            if (heightTimesMap.isEmpty()) {
                xTimesMap.put(nodes[i].x, 0);
            } else {
                xTimesMap.put(nodes[i].x, heightTimesMap.lastKey());
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int preHeight = 0;
        for (Map.Entry<Integer, Integer> entry : xTimesMap.entrySet()) {
            int curX = entry.getKey();
            int curMaxHeight = entry.getValue();
            if (curMaxHeight != preHeight) {
                if (preHeight != 0) {
                    res.add(new ArrayList<>(Arrays.asList(start, curX, preHeight)));
                }
                start = curX;
                preHeight = curMaxHeight;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(6, "我是6");
        map.put(3, "我是3");
        map.put(9, "我是9");
        map.put(1, "我是1");
        map.put(2, "我是2");
        map.put(5, "我是5");
        map.put(1, "我是1");
        System.out.println(map.containsKey(5));
        System.out.println(map.remove(5));
        System.out.println(map.containsKey(5));
        System.out.println(map.get(9));

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        //查询<=num，离这个num最近的key是谁
        System.out.println(map.floorKey(5));
        //查询>=num，离这个num最近的key是谁
        System.out.println(map.floorKey(5));

        //所有的方法，性能O{logN}

    }
}
