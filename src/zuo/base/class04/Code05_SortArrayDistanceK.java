package zuo.base.class04;

import java.util.PriorityQueue;

public class Code05_SortArrayDistanceK {
    public void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        int index = 0;
        for (index = 0; index < Math.min(k, arr.length); index++) {
            q.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++, i++) {
            arr[i] = q.poll();
            q.add(arr[index]);
        }
        while (!q.isEmpty()) {
            arr[i++] = q.poll();
        }
    }

    public static void main(String[] args) {

    }
}
