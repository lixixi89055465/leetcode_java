package zuo.intermediate.class07;


public class Problem02 {
    public static void printNumberNoInArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int value : arr) {
            modify(value, arr);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                System.out.println(i + 1);
            }
        }
    }

    public static void modify(int value, int[] arr) {
        while (arr[value - 1] != arr[value]) {
            int tmp = arr[value - 1];
            arr[value - 1] = value;
            value = tmp;
        }
    }

    public static void main(String[] args) {
        int[] test = {3, 2, 3, 5, 6, 1, 6};
        printNumberNoInArray(test);
    }

}
