package baidu;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int huai = in.nextInt();
        List<Integer> arr = new ArrayList<Integer>(huai);
        int i = 0;
        while (i < huai) {
            arr.add(in.nextInt());
        }
        while (n > 0) {
            switch (n) {
                case 1:
                    System.out.println(0);
                    break;
                case 2:
                    System.out.println(1);
                    break;
                case 3:
                    System.out.println(2);
                    break;
                default:
                    int[] dp = new int[n + 1];
                    dp[1] = 0;
                    dp[2] = 1;
                    dp[3] = 2;
                    for (i = 4; i <= n; i++) {
                        if (arr.contains(i)) {
                            dp[i] = dp[i-1];
                        } else {
                            dp[i] = dp[i - 1] + dp[i - 2] + 1;
                        }
                    }
                    System.out.println(dp[n]);
            }
            n--;
        }
        in.close();
    }
}