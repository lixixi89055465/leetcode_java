package zuo.base.chass01;

public class Code02_BubbleSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }

    }

    //    private static void swap(int[] arr, int i, int minIndex) {
//        int tmp = arr[i];
//        arr[i] = arr[minIndex];
//        arr[minIndex] = tmp;
//    }
    private static void swapBit(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 343, 5, 46, 547, 5, 64, 54, 99};
        Code02_BubbleSort.selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + ",");
        }
    }
}
