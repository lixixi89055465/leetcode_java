package zuo.base.class06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Code06_Dijkstra {
    public static HashMap<Node, Integer> dijkstra(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselected(distanceMap, selectNodes);
        while (null != minNode) {
            selectNodes.add(minNode);
            for (Node next : minNode.nexts) {
                if (!distanceMap.containsKey(next)) {
                    distanceMap.put(next, distanceMap.get(minNode) + minNode.value);
                } else if (distanceMap.get(next) > distanceMap.get(minNode) + minNode.value) {
                    distanceMap.put(next, distanceMap.get(minNode) + minNode.value);
                }
            }
            minNode = getMinDistanceAndUnselected(distanceMap, selectNodes);
        }
        return distanceMap;

    }

    private static Node getMinDistanceAndUnselected(HashMap<Node, Integer> distanceMap, HashSet<Node> selectNodes) {
        Node result = null;
        Integer minValues = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> nodeIntegerEntry : distanceMap.entrySet()) {
            if (minValues > nodeIntegerEntry.getValue() && !selectNodes.contains(nodeIntegerEntry.getKey())) {
                result = nodeIntegerEntry.getKey();
                minValues = nodeIntegerEntry.getValue();
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
