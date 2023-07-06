package leetcode.a900;

public class test01 {
    public static void main(String[] args) {
        long temp =2;
        long value = temp;
        long reverse = 0;
        while (value > 0) {
            reverse += (value % 10);
            reverse*=10;
            value /= 10;
        }
        reverse/=10;
        System.out.println(reverse);
    }
}
