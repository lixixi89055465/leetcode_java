package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class HJ16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line01 = sc.nextLine().split(" ");
        int N = Integer.parseInt(line01[0]);
        int m = Integer.parseInt(line01[1]);
        int[] varr = new int[m + 1];
        int[] warr = new int[m + 1];
        int[] qarr = new int[m + 1];
        ArrayList<Integer>[] narr = new ArrayList[N + 1];
        int weightLen = 0;
        for (int i = 1; i <= m; i++) {
            String[] line = sc.nextLine().split(" ");
            varr[i] = Integer.parseInt(line[0]) / 10;
            warr[i] = Integer.parseInt(line[1]);
            qarr[i] = Integer.parseInt(line[2]);
            if (qarr[i] == 0) {
                weightLen += 1;
                if (narr[i] == null) {
                    narr[i] = new ArrayList<>();
                }
                narr[i].add(0, i);
            } else {
                if (narr[qarr[i]] == null) {
                    narr[qarr[i]] = new ArrayList<>();
                }
                narr[qarr[i]].add(i);
            }
        }
        ArrayList<Integer>[] vPrice = new ArrayList[weightLen];
        ArrayList<Integer>[] value = new ArrayList[weightLen];
        int start = 0;
        for (int i = 0; i < narr.length; i++) {
            if (narr[i] != null) {
                if (value[start] == null) {
                    value[start] = new ArrayList<>();
                }
                if (vPrice[start] == null) {
                    vPrice[start] = new ArrayList<>();
                }
                vPrice[start].add(warr[narr[i].get(0)] * varr[narr[i].get(0)]);
                value[start].add(varr[narr[i].get(0)]);
                if (narr[i].size() >= 2) {
                    vPrice[start].add(vPrice[start].get(0) + warr[narr[i].get(1)] * varr[narr[i].get(1)]);
                    value[start].add(value[start].get(0) + varr[narr[i].get(1)]);
                }
                if (narr[i].size() == 3) {
                    vPrice[start].add(vPrice[start].get(0) + warr[narr[i].get(2)] * varr[narr[i].get(2)]);
                    value[start].add(value[start].get(0) + varr[narr[i].get(2)]);

                    vPrice[start].add(vPrice[start].get(1) + warr[narr[i].get(2)] * varr[narr[i].get(2)]);
                    value[start].add(value[start].get(1) + varr[narr[i].get(2)]);
                }
                start++;
            }
        }
        int[] dp = new int[N / 10 + 1];
        for (int i = 0; i < vPrice.length; i++) {
            for (int j = N / 10; j >= 1; j--) {
                for (int k = 0; k < vPrice[i].size(); k++) {
                    if (value[i].get(k) <= j) {
                        dp[j] = Math.max(dp[j], dp[j - value[i].get(k)] + vPrice[i].get(k));
                    }
                }
            }
        }
        System.out.println(dp[N / 10] * 10);
    }
}
