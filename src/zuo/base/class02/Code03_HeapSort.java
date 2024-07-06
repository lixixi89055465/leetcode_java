package zuo.base.class02;


import jdk.management.resource.internal.ResourceNatives;
import utils.RandomUtils;

import java.util.Random;

public class Code03_HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        RandomUtils.swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            RandomUtils.swap(arr, 0, --size);
        }

    }


    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            RandomUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index)
                break;
            RandomUtils.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void main(String[] args) {
        int[] arr = RandomUtils.generateRandomArray(100, 100);
        int[] copyArr = RandomUtils.copyArray(arr);
        heapSort(arr);
        RandomUtils.sort(copyArr );



        boolean equal = RandomUtils.isEqual(arr, copyArr);
        RandomUtils.printArray(arr);
        RandomUtils.printArray(copyArr);
        System.out.println(equal);
    }
}
