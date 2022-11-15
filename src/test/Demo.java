package test;

import java.util.Arrays;

public class Demo {
    public static void quickSort(int[] array, int low, int high) {

        /**
         * 分析：
         * 1.选定一个基准值，array[low]
         * 2.右指针从右向左遍历high--，查找比基准值小的数据，左指针从左向右low++，查找比基准值大的数据
         * 3.如果指针未相遇，交换左右两值位置，如果指针相遇，则替换基准值的位置
         * 4.左递归，右递归
         */
        // 方法退出条件,指针相遇或错过
        if (low >= high) {
            return;
        }
        // 1. 指定基准值和左右指针记录位置
        int pivot = array[low];
        int l = low;
        int r = high;
        int temp = 0;
        // 2. 遍历条件，左右指针位置
        while (l < r) {
            // 2.1 右侧遍历
            while (l < r && array[r] >= pivot) {
                r--;
            }
            // 2.2 左侧遍历
            while (l < r && array[l] <= pivot) {
                l++;
            }
            // 2.3 l指针还在r指针左侧，尚未相遇
            if (l < r) {
                temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }
        // 3. 当左右指针相遇，交换基准值位置
        array[low] = array[l];
        array[l] = pivot;
        // 4. 根据条件左侧递归遍历
        if (low < l) {
            quickSort(array, low, l - 1);
        }
        // 5. 根据条件右侧递归遍历
        if (r < high) {
            quickSort(array, r + 1, high);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,9,5,2,4,8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

