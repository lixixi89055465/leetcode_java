package zuo.base.chass01;

import utils.RandomUtils;

public class Code04_BSExist {
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static void main(String[] args) {
        int arr[] = RandomUtils.generateRandomArray(100,100);
        RandomUtils.sort(arr);
        RandomUtils.printArray(arr);

        boolean exist = exist(arr, 10);
        System.out.println(exist);

    }
}
