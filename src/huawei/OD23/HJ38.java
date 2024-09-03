package huawei.OD23;

import java.util.Scanner;

public class HJ38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float init = sc.nextFloat();
        float sum = init;
        for (int i = 1; i < 5; i++) {
            sum += init;
            init /= 2;
        }
        System.out.println(sum);
        System.out.println(init/2);
    }
}
