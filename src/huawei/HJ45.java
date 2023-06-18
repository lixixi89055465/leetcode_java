package huawei;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HJ45 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = sc.nextInt();
        while (n > 0) {
            String s = sc.next();
            process(s);
            n--;
        }

    }

    private static class Node {
        public int count = 0;
        public char alpha;

        public Node(int count, char alpha) {
            this.count = count;
            this.alpha = alpha;
        }
    }

    private static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.count - o1.count;
        }
    }

    private static void process(String s) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
        }

        map.entrySet().forEach(e -> {
            queue.add(new Node(e.getValue(), e.getKey()));
        });
        int alpha26 = 26;
        int res = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            res += poll.count * alpha26--;
        }
        System.out.println(res);
    }
}
