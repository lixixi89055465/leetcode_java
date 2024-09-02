package test;

import java.util.Scanner;
import java.util.TreeSet;

public class test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int A= Integer.parseInt(split[0]);
        int B= Integer.parseInt(split[1]);
        int time=Integer.parseInt(split[2]);
        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 0; i <= time; i++) {
            result.add(i*A+ (time-i)*B);
        }
        System.out.println(result);
    }

}
