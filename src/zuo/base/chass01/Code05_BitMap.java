package zuo.base.chass01;

public class Code05_BitMap {
    public static void main(String[] args) {
        int[] arr = new int[128];
        int i = 162;
        int numIndex = i / 32;
        int bitIndex = i % 32;
        arr[numIndex] = 15;
        int s = ((arr[numIndex] >> bitIndex) & 1);
        arr[numIndex] = arr[numIndex] | (1 << (bitIndex + 2));
        arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));
        System.out.println(arr[numIndex]);
    }
}
