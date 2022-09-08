package base.class09;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Code03_LessMoneySplitGold {
    public static int lessMoney2(int[] arr) {
        PriorityQueue<Integer> stack = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            stack.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (stack.size() > 0) {
            cur = stack.poll() + stack.poll();
            sum += cur;
            stack.add(cur);

        }
        return sum;
    }
}
