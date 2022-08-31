package base.chass01;

public class Code03_InsertSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[i] > arr[j + 1]; j--) {
                swap(arr, i, j);
            }

        }

    }

    //    private static void swap(int[] arr, int i, int minIndex) {
//        int tmp = arr[i];
//        arr[i] = arr[minIndex];
//        arr[minIndex] = tmp;
//    }
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 343, 5, 46, 547, 5, 64, 54, 99};
        Code03_InsertSort.selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + ",");
        }
    }
}
