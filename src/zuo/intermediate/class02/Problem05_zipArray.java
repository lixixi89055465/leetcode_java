package zuo.intermediate.class02;

public class Problem05_zipArray {
    private static boolean findInZipArray(int[][] zipArr, int target) {
        if (zipArr == null || zipArr.length == 0) {
            return false;
        }
        int N = zipArr.length;
        int M = zipArr[0].length;
        int i = 0, j = M - 1;
        while (zipArr[i][j] != target) {
            if (zipArr[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return target == zipArr[i][j];


    }

    public static void main(String[] args) {

    }
}
