package zuo.base.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code05_IPO {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> s1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return capital[o1] - capital[o2];
            }
        });
        PriorityQueue<Integer> s2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return profits[o2] - profits[o1];
            }
        });
        for (int i = 0; i < capital.length; i++) {
            if (capital[i] > w) {
                s2.add(i);
            } else {
                s1.add(i);
            }
        }
        while (k-- > 0) {
            while (!s2.isEmpty() && capital[s2.peek()] <= w) {
                s1.add(s2.poll());
            }
            if (s1.isEmpty()) {
                return w;
            }
            w += profits[s1.poll()];
        }
        return w;

    }
}
