package leetcode.a1700;

import java.util.Arrays;

public class S1710maximumUnits {
    protected static class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
            int res = 0;
            for (int[] boxType : boxTypes) {
                int numberOfBoxes = boxType[0];
                int numberOfUnitPerBox = boxType[1];
                if (numberOfBoxes < truckSize) {
                    res += numberOfBoxes * numberOfUnitPerBox;
                    truckSize -= numberOfBoxes;
                } else {
                    res += truckSize * numberOfUnitPerBox;
                    break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
