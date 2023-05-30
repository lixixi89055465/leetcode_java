package test;

import java.util.*;

public class Test04 {
    private static class Node {
        public int value;
        public List<Node> nexts;

        public Node(int value) {
            this.value = value;
            this.nexts = new ArrayList<>();
        }
    }

    public static void process0(Node start, Node ends) {
        ArrayList<Node> visits = new ArrayList<>();
        process1(start, ends, visits);
    }

    public static void process1(Node node, Node ends, List<Node> visits) {
        if (node == null) {
            return;
        }
        if (node == ends) {
            for (Node visit : visits) {
                System.out.print(visit.value);
            }
            System.out.println();
            return;
        }
        visits.add(node);
        for (Node next : node.nexts) {
            if (!visits.contains(next)) {
                process1(next, ends, visits);
                visits.remove(next);
            }
        }

    }


    public static void main(String[] args) {

        Node start = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node ends = new Node(0);
        start.nexts.add(node1);
        node1.nexts.add(node2);
        node1.nexts.add(node7);
        node2.nexts.add(node3);
        node2.nexts.add(node8);
        node3.nexts.add(node4);
        node4.nexts.add(node5);
        node4.nexts.add(node9);


        node5.nexts.add(node6);
        node6.nexts.add(ends);
        node7.nexts.add(node8);
        node8.nexts.add(node2);
        node9.nexts.add(node5);
        process0(start, ends);
    }
}
