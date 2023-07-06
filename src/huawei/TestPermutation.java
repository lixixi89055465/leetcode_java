package huawei;

public class TestPermutation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        permutation(arr, 0, arr.length - 1);

    }

    private static void permutation(int[] arr, int position, int end) {
        if (position == end) {
            printarr(arr);
        } else {
            for (int index = position; index < end; index++) {
                swap(arr, position, index);
                permutation(arr, position + 1, end);
                swap(arr, position, index);
            }
        }
    }

    private static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
