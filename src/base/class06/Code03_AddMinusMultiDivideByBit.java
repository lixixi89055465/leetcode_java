package base.class06;

/**
 * 字节操作
 */
public class Code03_AddMinusMultiDivideByBit {
    public static int add(int a, int b) {
        int sum = 0;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }
    public static int multi(int a ,int b){
        int res=0;
        while (b!=0){
        }
        return 0;
    }
}
