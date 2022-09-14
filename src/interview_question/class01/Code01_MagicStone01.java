package interview_question.class01;

public class Code01_MagicStone01 {
    public static int dpTest1(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length % 2 != 0) {
            return -1;
        }
        int[][] dp = new int[arr.length][2];
        int blueCount = 0;
        int redCount = 0;
        int index = 0;
        return process1(arr, index, blueCount, redCount);
    }

    private static int process1(int[][] arr, int index, int redCount, int blueCount) {
        if (index == arr.length) {
            if (blueCount != arr.length / 2 || redCount != arr.length / 2) {
                return Integer.MAX_VALUE;
            }
            return 0;
        }
        if (arr[index][0] == 1) {
            redCount += 1;
            if (redCount > arr.length / 2) {
                return Integer.MAX_VALUE;
            }
            return process1(arr, index + 1, redCount, blueCount);
        }
        if (arr[index][0] == 2) {
            blueCount += 1;
            if (blueCount > arr.length / 2) {
                return Integer.MAX_VALUE;
            }
            return process1(arr, index + 1, redCount, blueCount);
        }

        int redValue = process1(arr, index + 1, redCount + 1, blueCount);
        int blueValue = process1(arr, index + 1, redCount, blueCount + 1);
        if (redCount == Integer.MAX_VALUE && blueValue == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        redValue = redValue == Integer.MAX_VALUE ? Integer.MAX_VALUE : redValue + arr[index][1];
        blueValue = blueValue == Integer.MAX_VALUE ? Integer.MAX_VALUE : blueValue + arr[index][2];
        return Math.min(redValue, blueValue);
    }



    public static void main(String[] args) {
        int[][] stones = {{1, 5, 3}, {2, 7, 9}, {0, 6, 4}, {0, 7, 9}, {0, 2, 1}, {0, 5, 9}};
        System.out.println(dpTest1(stones));
//        int[][] arr = new int[][]{
//                new int[]{0, 4, 7},
//                new int[]{1, 4, 7},
//                new int[]{2, 4, 7},
//                new int[]{0, 4, 7},
//                new int[]{0, 2, 7},
//                new int[]{0, 7, 5},
//        };
//        int result = dpTest1(arr);
//        System.out.println(result);
    }
}
