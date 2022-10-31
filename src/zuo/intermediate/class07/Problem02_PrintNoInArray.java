package zuo.intermediate.class07;

public class Problem02_PrintNoInArray {
    public static void printNumberNoInArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == i + 1) {
                continue;
            }
            modify(arr, i);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                System.out.println(i+1);
            }
        }
    }

    private static void modify(int[] arr, int index) {
        int cache = arr[index];
        int tmp = 0;
        while (cache != index + 1) {
            tmp = cache;
            cache = arr[cache - 1];
            arr[tmp-1] = tmp;
            index = tmp - 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 6, 5, 2, 2, 4, 5};
        printNumberNoInArray(arr);
    }
}
