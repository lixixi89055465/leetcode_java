package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }
        int res = process(nArr, N, K);
        System.out.println(res);


//        int N = 8;
//        int K = 3;
//        int[] nArr = new int[]{1, 2, 3, 2, 1, 4, 5, 1};
////        int[] nArr = new int[]{4, 1, 2, 3, 1, 4, 5, 1};
//        int res = process(nArr, N, K);
//        System.out.println(res);


    }

    private static int process(int[] nArr, int N, int K) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;

        while (left <= right && right < nArr.length) {
            int[] s = getCount(count);
            res = Math.max(res, s[1]);
            if (s[0] > K) {
                if (count.get(nArr[left]) == 1) {
//                    count.remove(nArr[left]);
                    count.keySet().remove(nArr[left]);
//                    res = Math.max(res, right - left );
                } else {
                    count.put(nArr[left], count.get(nArr[left]) - 1);
                }
                left++;
                continue;
            }

            if (count.containsKey(nArr[right])) {
                count.put(nArr[right], 1 + count.get(nArr[right]));
                right++;
            } else {
                if (count.size() == K) {
                    count.keySet().remove(nArr[left]);
                    left++;
                    count.put(nArr[right++], 1);
                } else {
                    count.put(nArr[right], 1);
                    right++;
                }
            }

        }
        return res;

    }

    private static int[] getCount(HashMap<Integer, Integer> count) {
        int[] res = new int[2];
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() != null) {
                res[0]++;
                res[1] += entry.getValue();
            }
        }
        return res;
    }

}
