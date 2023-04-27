package zuo.base.class04;

import java.util.LinkedList;

public class Code01_SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr != null && w < arr.length && arr.length != 0) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.add(i);
            if (i - w == qmax.peekFirst()) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
