package zuo.base.chass01;

/**
 * arr中，只有一种数，出现奇数次
 */
public class Code07_EvenTimesOddTimes {
    public static void getLessIndex(int[] arr) {
        int ero = 0;
        for (int i = 0; i < arr.length; i++) {
            ero ^= arr[i];
        }
        System.out.println(ero);
    }

    public static void printOddTimeNums2(int[] arr) {
        int eor=0;
        for (int i : arr) {
            eor^=i;
        }
        int rightOne=eor&(~eor+1);
        int onlyOne=0;
        for (int cur : arr) {
            if((cur&rightOne)==0){
                onlyOne^=cur;
            }
        }
        System.out.println(onlyOne+"\t"+(eor^onlyOne));

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 7, 9};
        printOddTimeNums2(arr);
    }


    public static int bitCounts(int N) {
        int count = 0;
        while (N != 0) {
            int rightOne = N & (~N + 1);
            N ^= rightOne;
            count += 1;
        }
        return count;
    }
}
