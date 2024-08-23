package zuo.base_advance.class04;

import java.util.LinkedList;

/**
 * 单调栈
 */
public class Code01_SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int index=0;
        LinkedList<Integer> qmax = new LinkedList<>();
        int res[] = new int[arr.length - w + 1];
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && qmax.peekLast() <= arr[i]) {
                qmax.pollLast();
            }
            qmax.add(i);
            if(qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++]=arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        printArray(getMaxWindow(arr, w));

    }

}
