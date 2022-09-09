package base.class11;

import java.util.Stack;

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

    public static void hanoi2(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }

    private static void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("move\t1\tfrom\t" + from + "\tto\t" + to);
            return;
        }
        func(n - 1, from, other, to);
        System.out.println("Move\t" + n + "\tfrom\t" + from + "\tto\t" + to);
        func(n - 1, other, to, from);
    }

    public static class Record {
        public boolean finish1;
        public int base;
        public String from;
        public String to;
        public String other;

        public Record(boolean finish1, int base, String from, String to, String other) {
            this.finish1 = finish1;
            this.base = base;
            this.from = from;
            this.to = to;
            this.other = other;
        }
    }

    public static void hanoi3(int N) {
        if (N < 1) {
            return;
        }
        Stack<Record> stack = new Stack<>();
        stack.add(new Record(false, N, "left", "right", "mid"));
        while (!stack.isEmpty()) {
            Record cur = stack.pop();
            if (!cur.finish1) {
                stack.push(cur);
            } else {

            }

        }
    }


    public static void main(String[] args) {
//        hanoi1(3);
        hanoi2(3);
    }

}
