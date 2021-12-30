package baidu;

public class example03 {
    private static Integer cnt = 0;

    private static void func(int... numbers) {
        for (int n : numbers) {
            if (n % 2 == 1)
                System.out.print(n >> 1);
            else
                System.out.print(cnt++);
        }
    }

    private static void testBit() {
        int n = 3;
        int[] numbers = new int[n << 1];
        int k = 0;
        for (int i = -n; i < n; i++) {
            numbers[k++] = i;
        }
        func(numbers);
    }

    public static void main(String[] args) {
        testBit();
    }
}
