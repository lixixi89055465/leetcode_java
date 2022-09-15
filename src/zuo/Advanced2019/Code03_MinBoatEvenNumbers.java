package zuo.Advanced2019;

public class Code03_MinBoatEvenNumbers {
    public static void main(String[] args) {
        int i = 178;
        int[] arr = new int[10];
        int numIndex = i / 32;
        int bitIndex = 178 % 32;
        int s = (arr[numIndex] >> (bitIndex));
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);
        arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));
        int bit = (arr[i / 32] >> (i % 32)) & 1;

    }
}
