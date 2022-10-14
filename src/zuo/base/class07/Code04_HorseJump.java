package zuo.base.class07;

public class Code04_HorseJump {
    public static int getWays(int x, int y, int k) {
        return process(x, y, k);
    }

    /**
     * 潜台词：从（0，0）位置出发
     * 要去往(x,y) 位置，必须跳 step步 ，
     * 返回方法数
     *
     * @param x
     * @param y
     * @param step
     * @return
     */
    private static int process(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        if (step == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        return process(x - 1, y + 2, step - 1)
                + process(x + 1, y + 2, step - 1)
                + process(x + 2, y + 1, step - 1)
                + process(x + 2, y - 1, step - 1)
                + process(x + 1, y - 2, step - 1)
                + process(x - 1, y - 2, step - 1)
                + process(x - 2, y - 1, step - 1)
                + process(x - 2, y + 1, step - 1);

    }

    public static int dpWays(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9 || step < 0) {
            return 0;
        }
        int[][][] dp = new int[9][10][step + 1];
        dp[0][0][0] = 1;
        for (int h = 1; h <= step; h++) {
            for (int r = 8; r >= 0; r--) {
                for (int c = 9; c >= 0; c--) {
                    dp[r][c][h] += getValues(dp, r - 1, c + 2, h - 1);
                    dp[r][c][h] += getValues(dp, r + 2, c + 1, h - 1);
                    dp[r][c][h] += getValues(dp, r + 2, c - 1, h - 1);
                    dp[r][c][h] += getValues(dp, r + 1, c - 2, h - 1);
                    dp[r][c][h] += getValues(dp, r - 1, c - 2, h - 1);
                    dp[r][c][h] += getValues(dp, r - 2, c - 1, h - 1);
                    dp[r][c][h] += getValues(dp, r - 2, c + 1, h - 1);

                }
            }

        }
        return dp[x][y][step];
    }

    private static int getValues(int[][][] dp, int row, int col, int step) {
        if (row < 0 || row > 8 || col < 0 || col > 9) {
            return 0;
        }
        return dp[row][col][step];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(getWays(x, y, step));
        System.out.println(dpWays(x, y, step));
    }

}
