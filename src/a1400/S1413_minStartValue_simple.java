package a1400;

class Solution {
    public int minStartValue(int[] nums) {
        int accSum = 0, accSumMin = 0;
        for (int num : nums) {
            accSum += num;
            accSumMin = Math.min(accSum, accSumMin);
        }
        return -accSum + 1;
    }
}

public class S1413_minStartValue_simple {
    public static void main(String[] args) {

    }
}
