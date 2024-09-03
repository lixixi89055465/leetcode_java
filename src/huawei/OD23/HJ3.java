package huawei.OD23;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Integer> nSet = new TreeSet<Integer>();
        for (int i = 0; i < N; i++) {
            nSet.add(sc.nextInt());
        }
        nSet.forEach(System.out::println);
    }
}
