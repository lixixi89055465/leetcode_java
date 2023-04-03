package zuo.base.class06;

import java.util.*;

public class Code05_Prim {
    private static class Node {
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            this.nexts = new ArrayList<>();
            this.edges = new ArrayList<>();
        }
    }

    private static class Edge {
        public Node from;
        public Node to;
        public int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static class Graph {
        public ArrayList<Node> nodes;
        public ArrayList<Edge> edges;

        public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
            this.nodes = nodes;
            this.edges = edges;
        }
    }

    private static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();
        for (Node node : graph.nodes) {
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge nextEdges = priorityQueue.poll();
                    if (!set.contains(nextEdges.to)) {
                        result.add(nextEdges);
                        set.add(nextEdges.to);
                        for (Edge edge : nextEdges.to.edges) {
                            priorityQueue.add(edge);
                        }
                    }
                }
            }
        }
    }

}