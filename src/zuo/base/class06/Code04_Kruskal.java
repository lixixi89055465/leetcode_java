package zuo.base.class06;

import java.util.*;

public class Code04_Kruskal {
    public static class MySets {
        public HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> nodes) {
            for (Node cur : nodes) {
                ArrayList<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node node : toSet) {
                fromSet.add(node);
                setMap.put(node, fromSet);
            }
        }
    }

}
