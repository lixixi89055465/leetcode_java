package test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test07 {
    public static void main(String[] args) {
        int[] tArr = new int[]{3, 4, 7};
        int[] aArr = new int[]{9, 3, 2};
        int[] bArr = new int[]{11, 6, 11};
        System.out.println(process(tArr, aArr, bArr, 3, 12));

    }

    private static class Node {
        public int t;
        public int v;
        public int index;

        public Node(int t, int v, int index) {
            this.t = t;
            this.v = v;
            this.index = index;
        }
    }

    private static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.v * o2.t - o1.t * o2.v;
        }
    }

    private static int process(int[] tArr, int[] aArr, int bArr[], int n, int m) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        for (int i = 0; i < n; i++) {
            queue.add(new Node(tArr[i], bArr[i] - aArr[i], i));
        }
        int r = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.t <= m) {
                m -= cur.t;
                r += cur.v;
            } else {
                queue.poll();
            }
        }
        return r;

    }
}
