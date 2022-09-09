package base.class10;


import java.util.*;

public class Code05_Prim {
    public static class UnionFind {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFind(Graph graph) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node : graph.nodes.values()) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node node) {
            Node cur = node;
            Stack<Node> path = new Stack<>();

            while (cur != fatherMap.get(cur)) {
                path.push(cur);
                cur = fatherMap.get(cur);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aP = findFather(a);
            Node bP = findFather(b);
            if (aP != bP) {
                int aSize = sizeMap.get(aP);
                int bSize = sizeMap.get(bP);
                Node big = aSize >= bSize ? aP : bP;
                Node small = aSize >= bSize ? bP : aP;
                fatherMap.put(small, big);
                sizeMap.put(small, aSize + bSize);
                sizeMap.remove(small);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge :
                                toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }

                }

            }

        }
        return result;

    }

}
