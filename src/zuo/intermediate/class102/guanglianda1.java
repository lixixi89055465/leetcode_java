package zuo.interview_question.class102;

import java.util.Scanner;

public class guanglianda1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int result = getResult(n, m, k);
        System.out.println(result);
    }

    private static int getResult(int n, int m, int k) {
        int result = 0;
        k--;
        while (k > 0) {
            int big = n > m ? n : m;
            int min = n > m ? m : n;
            while (k>0&&min==1){

            }
            big--;
            result += min * min;
            k--;
            int minL = min - 1;
//            while (minL == 0 && k > 0) {
//                result += 1;
//                k--;
//            }
            while (k > 0 && minL > 0) {
                minL--;
                k--;
                result += 1;
            }
            m = big;
            n = min;
        }
        return result;
    }

}
