package zuo.base.class06;


import java.util.*;

public class Code06_Dijkstra02 {
    private static class NodeRecord {
        public Node key;
        public Integer value;

        public NodeRecord(Node key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class NodeHeap {
        public PriorityQueue<NodeRecord> queue = new PriorityQueue<>(new Comparator<NodeRecord>() {
            @Override
            public int compare(NodeRecord o1, NodeRecord o2) {
                return o1.value - o2.value;
            }
        });
        public HashSet<Node> exists = new HashSet<>();

        public void update(NodeRecord node) {
            exists.add(node.key);
            Node newNode = cloneNode(node.key);
            queue.add(new NodeRecord(newNode, node.value));
        }

        public Node cloneNode(Node from) {
            Node newNode = new Node(from.value);
            newNode.edges = from.edges;
            newNode.nexts = from.nexts;
            newNode.in = from.in;
            newNode.out = from.out;
            return newNode;
        }

        public void add(NodeRecord node) {
            queue.add(node);
        }

        public NodeRecord pop() {
            while (exists.contains(queue.peek().key)) {
                queue.poll();
            }
            return queue.poll();
        }
    }


    public static HashMap<Node, Integer> dijstra2(Node head, int size) {
        HashSet<Node> endNodes = new HashSet<>();
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);

        endNodes.add(head);
        Node nextNode = head;
        while (null != nextNode) {
            for (Edge edge : nextNode.edges) {
                if (!distanceMap.containsKey(edge.to)) {
                    distanceMap.put(edge.to, distanceMap.get(nextNode) + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(edge.to), distanceMap.get(nextNode) + edge.weight));
                }
            }
            nextNode = getMinNode(distanceMap, endNodes);
        }
        return distanceMap;
    }

    private static Node getMinNode(HashMap<Node, Integer> distanceMap, HashSet<Node> endNodes) {
        Integer minValue = Integer.MAX_VALUE;
        Node minNode = null;
        for (Map.Entry<Node, Integer> nodeIntegerEntry : distanceMap.entrySet()) {
            if (minValue > nodeIntegerEntry.getValue()) {
                minValue = nodeIntegerEntry.getValue();
                minNode = nodeIntegerEntry.getKey();
            }
        }
        return minNode;
    }
}
