package huawei.OD23;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ103 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int[] arr = new int[len];
//        for (int i = 0; i < len; i++) {
//            arr[i] = sc.nextInt();
//        }

//        int len = 6;
//        int[] arr = new int[]{2, 5, 1, 5, 4, 5};

        int len = 13;
        int[] arr = new int[]{237, 153, 196, 160, 154, 91, 195, 250, 129, 219, 14, 29, 209};
        int res = process(len, arr);
        System.out.println(res);
    }

    private static int process(int len, int[] arr) {
        if (len == 0 || arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
