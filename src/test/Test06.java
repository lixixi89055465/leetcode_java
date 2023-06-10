package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int pN = sc.nextInt();
            int[] pValue = new int[pN];
            for (int i1 = 0; i1 < pValue.length; i1++) {
                pValue[i1] = sc.nextInt();
            }

            int[] res = process(pN, pValue);
            for (int i1 = 0; i1 < res.length; i1++) {
                System.out.print(res[i1] + " ");
            }
            System.out.println();
        }
//        int N = 3;
//        int[] pArr = new int[]{0, 0, 1};
//        int N = 4;
//        int[] pArr = new int[]{1, 0, 1, 0};
//        int[] res = process(N, pArr);
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + " ");
//        }


    }

    private static int[] process(int pN, int[] pValue) {
        int zeroN = 0;
        int N = pValue.length;
        for (int i = 0; i < pValue.length; i++) {
            if (pValue[i] == 0) {
                zeroN++;
            }
        }
        int oneN = N - zeroN;

        int curZero = 0;
        int curOne = 0;
        int[] res = new int[pN];
        for (int i = 0; i < N; i++) {
            if (pValue[i] == 0) {
                curZero += 1;
                res[i] += zeroN - curZero;
                res[i] += curOne;
            } else {
                curOne += 1;
                res[i] += oneN - curOne;
                res[i] += curZero;
            }
        }
        return res;
    }
}
