package zuo.base.class08;

public class Code01_Hanoi {
    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "左", "右", "中");
        }
    }

    private static void func(int n, String start, String end, String other) {
        if (n == 1) {
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            func(n - 1, start, end, other);
            System.out.println("Move " + n + " from " + start + " to " + end);
            func(n - 1, other, end, start);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

}
