package zuo.base.class06;

import java.util.HashMap;
import java.util.HashSet;

public class Code06_Dijkstra {
    public static HashMap<Node, Integer> Dijstra(Node head) {
        HashSet<Node> selectNodes = new HashSet<>();
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        Node minNode = head;
        while (null != minNode) {
            selectNodes.add(minNode);
            for (Edge edge : minNode.edges) {
                int len = edge.weight + distanceMap.get(minNode);
                if (null == distanceMap.get(edge.to)) {
                    distanceMap.put(edge.to, len);
                } else {
                    distanceMap.put(edge.to, Math.min(len, distanceMap.get(edge.to)));
                }
            }
            minNode = getMinDistanceMap(selectNodes, distanceMap);
        }
        return distanceMap;
    }

    private static Node getMinDistanceMap(HashSet<Node> selectNodes, HashMap<Node, Integer> distanceMap) {
        Node minNode = null;
        Integer minValue = Integer.MAX_VALUE;
        for (Node node : distanceMap.keySet()) {
            if (!selectNodes.contains(node)&&minValue > distanceMap.get(node)) {
                minValue = distanceMap.get(node);
                minNode = node;
            }
        }
        return minNode;
    }

    public static void main(String[] args) {

    }
}
