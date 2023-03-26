package zuo.base.class02;

public class Code06_QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int num = arr[R];
        int p1 = L, p2 = L, i = L;
        while (i <= R) {
            if (num > arr[i]) {
                swap(arr, i, p1++);
                swap(arr, p2++, i);
            } else if (num == arr[i]) {
                swap(arr, i, p2++);
            }
            i++;
        }
        quickSort(arr, L, p1 - 1);
        quickSort(arr, p2, R);
        System.out.println(1111);
    }

    private static void swap(int[] arr, int i, int p1) {
        int temp = arr[i];
        arr[i] = arr[p1];
        arr[p1] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 5, 3, 7, 9, 2, 4, 6, 5, 5};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }


    }
}
