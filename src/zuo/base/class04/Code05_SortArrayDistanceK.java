package zuo.base.class04;

import java.util.PriorityQueue;

public class Code05_SortArrayDistanceK {
    public void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i=0;
        for(;index<arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i]=heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++]=heap.poll();
        }
    }

    public static void main(String[] args) {

    }
}
