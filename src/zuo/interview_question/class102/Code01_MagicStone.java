package zuo.interview_question.class102;

import java.util.Arrays;

public class Code01_MagicStone {
    public static int minCost(int[][] stones) {
        int n = stones.length;
        if ((n & 1) != 0) {
            return -1;
        }
        Arrays.sort(stones, (a, b) -> a[0] == 0 && b[0] == 0 ? (b[1] - b[2] - a[1] + a[2]) : (a[0] - b[0]));
        int zero = 0;
        int red = 0;
        int blue = 0;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            if (stones[i][0] == 0) {
                zero += 1;
                cost += stones[i][1];
            } else if (stones[i][0] == 1) {
                red++;
            } else {
                blue++;
            }
        }
        if (red > (n >> 1) || blue > (n >> 1)) {
            return -1;
        }
        blue = zero - ((n >> 1) - red);
        for (int i = 0; i < blue; i++) {
            cost += stones[i][2] - stones[i][1];
        }
        return cost;
    }

    public static void main(String[] args) {
        int[][] stones = {{1, 5, 3}, {2, 7, 9}, {0, 6, 4}, {0, 7, 9}, {0, 2, 1}, {0, 5, 9}};
        System.out.println(minCost(stones));
    }
}
