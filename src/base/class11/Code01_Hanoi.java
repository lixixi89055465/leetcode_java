package base.class11;

public class Code01_Hanoi {

    public static void hanoi1(int n) {
        leftToRight(n);
    }

    private static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("move " + n + "from left to right");
        midToright(n - 1);
    }

    private static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("move " + n + "from left to mid");
        rightToMid(n - 1);
    }

    private static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from right to mid");
            return;
        }
        rightToleft(n - 1);
        System.out.println("move " + n + "from right to mid");
        leftToMid(n - 1);
    }

    private static void rightToleft(int n) {
        if (n == 1) {
            System.out.println("move 1 from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("move " + n + "from right to left");
        midToleft(n - 1);
    }

    private static void midToleft(int n) {
        if (n == 1) {
            System.out.println("move 1 from mid to left");
            return;
        }
        midToright(n - 1);
        System.out.println("move " + n + "from mid to left");
        rightToleft(n - 1);
    }

    private static void midToright(int n) {
        if (n == 1) {
            System.out.println("move 1 from mid to right");
            return;
        }
        midToleft(n - 1);
        System.out.println("move " + n + "from mid to right");
        leftToRight(n - 1);
    }

    public static void main(String[] args) {
       hanoi1(3);
    }

}
