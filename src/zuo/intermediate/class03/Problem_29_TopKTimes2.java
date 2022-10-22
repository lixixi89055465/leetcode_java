package zuo.intermediate.class03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_29_TopKTimes2 {
    public static class Node {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public static class TopKRecod {
        Integer size;
        PriorityQueue<Node> minRootHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.times - o2.times;
            }
        });
        Map<String, Integer> strSizeMap = new HashMap<String, Integer>();


        public TopKRecod(int size) {
            this.size = size;
        }

        public void add(String str) {
            if (!strSizeMap.containsKey(str)) {
                strSizeMap.put(str, 1);
                if (minRootHeap.size() < size) {
                    minRootHeap.add(new Node(str, 1));
                }
                return;
            }
            strSizeMap.put(str, strSizeMap.get(str) + 1);
            if (minRootHeap.size() < this.size) {
                minRootHeap.add(new Node(str, strSizeMap.get(str)));
            } else if (minRootHeap.peek().times < strSizeMap.get(str)) {
                minRootHeap.poll();
                minRootHeap.add(new Node(str,

                        strSizeMap.get(str)));
            }
        }
        public void printTopk(){
            System.out.println("Top: ");
            while (!minRootHeap.isEmpty()){
                Node poll = minRootHeap.poll();
                System.out.println(poll.str + " : " + poll.times);
            }
        }

    }

    public static void main(String[] args) {
        TopKRecod topKRecod = new TopKRecod(3);
        topKRecod.add("ddd");
        topKRecod.add("ddd");
        topKRecod.add("ddd");
        topKRecod.add("ddd");
        topKRecod.add("ddd");
        topKRecod.add("ddd");
        topKRecod.add("aaa");
        topKRecod.add("bbb");
        topKRecod.add("bbb");
        topKRecod.add("ccc");
        topKRecod.add("ccc");
        topKRecod.add("ccc");
        topKRecod.add("ccc");
        topKRecod.add("ccc");
        topKRecod.add("aaa");
        topKRecod.add("aaa");

        topKRecod.printTopk();

    }

}
