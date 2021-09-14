package baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class example01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int Q = Integer.parseInt(sc.next());
        int i = 0;
        int j = 0;
        List<Integer> arr = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>(N+1);
        for (j = 0; j < N+1; j++) {
            res.add(1);
        }

        while (i < Q) {
            int tmp = Integer.parseInt(sc.next());
            arr.add(tmp);
            i++;
        }
        int q = Q;
        for (i = 0; i < Q; i++) {
            int k = (int) arr.get(i);
            res.set(0, 0);
            j = 0;
            int left = 0;
            int right = 1;
            int result = 0;
            while (j < k) {
                while (res.get(right) == 0) {
                    right++;
                    continue;
                }
                while (left < right && j < k) {
                    res.set(left, res.get(right));
                    j++;
                    result += (right - left);
                    res.set(right, 0);
                    left++;
//                    right++;
                    right++;
                    while (res.get(right) == 0) {
                        right++;
                        continue;
                    }
                }
            }
            System.out.print(result+" ");
        }

    }
}
