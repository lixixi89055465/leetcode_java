package zuo.base.class02;
/**
 * 不改进的快速排序
 * 1）把数组范围中的最后一个数作为划分值，然后把数组通过荷兰国旗问题分成三个部
 * 分：
 * 左侧<划分值、中间==划分值、右侧>划分值
 * 2）对左侧范围和右侧范围，递归执行
 * 分析
 * 1）划分值越靠近两侧，复杂度越高；划分值越靠近中间，复杂度越低
 * 2）可以轻而易举的举出最差的例子，所以不改进的快速排序时间复杂度为O(N^2)
 *
 *
 * 随机快速排序（改进的快速排序）
 * 1）在数组范围中，等概率随机选一个数作为划分值，然后把数组通过荷兰国旗问题分
 * 成三个部分：
 * 左侧<划分值、中间==划分值、右侧>划分值
 * 2）对左侧范围和右侧范围，递归执行
 * 3）时间复杂度为O(N*logN)
 *
 *
 */

import jdk.management.resource.internal.ResourceNatives;
import utils.RandomUtils;

import java.util.Random;


public class Code06_QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int mid=L+(R-L)/2;
            RandomUtils.swap(arr,mid,arr[R]);
            int[]p=partition(arr,L,R);
        }

    }//41, 79, 70,31

    private static int[] partition(int[] arr, int L, int R) {
        int less=L-1;
        int more=R;
        while (L<more){
            if(arr[L]<arr[R]){
                RandomUtils.swap(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                RandomUtils.swap(arr,--more,L);
            }else{
                L++;
            }
        }
        RandomUtils.swap(arr,more,R);
        return new int[]{less+1,more};
//        int less = L - 1;
//        int more = R;
//        while (L < more) {
//            if (arr[L] < arr[R]) {
//                RandomUtils.swap(arr, ++less, L++);
//            } else if (arr[L] > arr[R]) {
//                RandomUtils.swap(arr, --more, L);
//            } else {
//                L++;
//            }
//        }
//        RandomUtils.swap(arr, more, R);
    }


    public static void main(String[] args) {
        int arr[] = RandomUtils.generateRandomArray(100,100);
        int[] copyArr = RandomUtils.copyArray(arr);
        quickSort(arr);
        RandomUtils.sort(copyArr);
        boolean equal = RandomUtils.isEqual(arr, copyArr);
        RandomUtils.printArray(arr);
        RandomUtils.printArray(copyArr);
        System.out.println(equal);
    }
    //41 79 70 31 12 18 -26 22 14 -76 -72 -69 -43 14 -38 -23 65 -5 -44 -39 -42 -17 -13 -13 8 11 -11 -65 -17 -38 -11 -34 -12 -68 -16 -10 -10 -5 -5 -19 -19 -45 -10 -63 0 -14 5 11 28 43 22 30 30 20 13 1 5 33 36 36 37 59 70
}
