package huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ93 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int s5 = 0;
        int s3 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            if (arr[i] % 5 == 0) {
                s5 += arr[i];
            } else if (arr[i] % 3 == 0) {
                s3 += arr[i];
            } else {
                list.add(arr[i]);
            }
        }


//        int n = 4;
//        int[] arr = new int[]{1, 5, -5, 1};
//        int n = 3;
//        int[] arr = new int[]{3, 5, 8};
//        int n = 6;
//        int[] arr = new int[]{-4, -5, -5, -2, 1, -2};
//        int sum = 0;
//        int n = 7;
//        int[] arr = new int[]{3, -4, -1, 2, -4, -5, 5};
//        int sum = 0;
//        int s3 = 0, s5 = 0;
//        ArrayList<Integer> list = new ArrayList<>();


//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//            if (arr[i] % 5 == 0) {
//                s5 += arr[i];
//            } else if (arr[i] % 3 == 0) {
//                s3 += arr[i];
//            } else {
//                list.add(arr[i]);
//            }
//        }


        int sheng = sum - s3 - s5;
//        if (sheng < Math.abs(s3 - s5)) {
//            System.out.println(false);
//            return;
//        }
        HashSet<Integer> set = new HashSet<>();
        int value = sheng - Math.abs(s5 - s3);
        if (value % 2 != 0) {
            System.out.println(false);
            return;
        }
        if (s3 == s5) {
            System.out.println(true);
            return;
        }
        int pack = value / 2;
        for (int i = 0; i < list.size(); i++) {
            Set<Integer> newSet = new HashSet<>();
            int finalI = i;
            newSet.add(list.get(i));
            set.forEach(e -> {
                        int cur = e + list.get(finalI);
                        newSet.add(e + list.get(finalI));
                    }
            );
            set.addAll(newSet);
            if (set.contains(pack)) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}

