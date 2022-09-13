package base.class12;

public class Code06_Coffee {
    public static int minTime1(int[] arr, int n, int a, int b) {
        int[] times = new int[arr.length];
        int[] drink = new int[n];
        return forceMake(arr, times, 0, drink, n, a, b);
    }

    private static int forceMake(int[] arr, int[] times, int i, int[] drink, int n, int a, int b) {
        return 0;
    }

    public static int process(int[] drinks, int a, int b, int index, int washLine) {
        if (index == drinks.length - 1) {
            return Math.min(
                    Math.max(washLine, drinks[index]) + a,
                    drinks[index] + b
            );
        }
        int wash = Math.max(washLine, drinks[index]) + a;
        int next1 = process(drinks, a, b, index + 1, wash);
        int p1 = Math.max(wash, next1);
        int dry = drinks[index] + b;
        int next2 = process(drinks, a, b, index + 1, washLine);
        int p2 = Math.max(dry, next2);
        return Math.min(p1, p2);

    }

    public static void main(String[] args) {

    }
}
