package zuo.Advanced2019.class04;

import java.util.LinkedList;

public class Code01_SlidingWindowMaxArray {
    public static class WindwMax {
        private int L;
        private int R;
        private int[] arr;
        LinkedList<Integer> qMax;

        public WindwMax(int[] arr) {
            this.arr = arr;
            L = -1;
            R = 0;
            qMax = new LinkedList<>();
        }

        public void addNumFromRighgt() {
            if (R == arr.length) {
                return;
            }
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                qMax.pollLast();
            }
            qMax.push(arr[R]);
            R++;
        }
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length == 0 || w < 1) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && qmax.peekLast() <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                arr[index++] = qmax.peekFirst();
            }
        }
        return arr;
    }
}
