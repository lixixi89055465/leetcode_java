package zuo.base.chass01;

import utils.RandomUtils;

import java.util.Random;

public class Code02_BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length-1; i>0; i--) {
            for (int j = 0; j < i; j++) {
                RandomUtils.swapBit(arr,i,j);
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = RandomUtils.generateRandomArray(100,100);
        RandomUtils.printArray(arr);
        int[] copyArr= RandomUtils.copyArray(arr);
        boolean equal = RandomUtils.isEqual(arr, copyArr);
        System.out.println(equal);
    }

}
