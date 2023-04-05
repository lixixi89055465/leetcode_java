package zuo.base.class07;

import java.util.PriorityQueue;

public class Code03_LessMoneySplitGold {
    public static int lessMoney(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int result = 0;
        while (pQ.size() > 1) {
            Integer p1 = pQ.poll() + pQ.poll();
            result += p1;
            pQ.add(p1);
        }
        return result;
    }

}
