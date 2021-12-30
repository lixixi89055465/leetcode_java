package baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class example04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int n = N;
        List<Integer> arr = new ArrayList<Integer>(N);
        while (n > 0) {
            arr.add(Integer.parseInt(sc.next()));
            n--;
        }

        Integer min;
        Integer sum = 0;
        int i = 0, j;
        while (i < N) {
            if (arr.get(i) == 0) {
                i++;
                continue;
            }
            min = arr.get(i);
            for (j = i; j < arr.size() && arr.get(j) > 0; j++) {
                if (arr.get(j) < min) {
                    min = arr.get(j);
                }
            }
            sum += min;
            for (int k = i; k < j; k++) {
                arr.set(k, arr.get(k) - min);
            }
        }
        System.out.println(sum);
    }

}