package zuo.base.class03;

import java.util.PriorityQueue;

public class test1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(5);
        heap.add(7);
        heap.add(3);
        heap.add(0);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

    }
}
