package zuo.base.class12;

public class Code06_ConvertToLetterString {
    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
    }

    public static int dpWay2(char[] str, int i, int[] dp) {
        if (dp[i] > 0) {
            return dp[i];
        }
        if (i == str.length) {
            dp[i] = 1;
            return dp[i];
        }
        if (str[i] == '0') {
            dp[i] = 0;
            return 0;
        }
        if (str[i] == '1') {
//            int minDistance = process(str, i + 1);
            dp[i + 1] = process(str, i + 1);
            dp[i] = dp[i + 1];
            if (i + 1 < str.length) {
                dp[i + 2] = process(str, i + 2);
                dp[i] += dp[i + 2];
            }
            return dp[i];
        }
        if (str[i] == '2') {
//            int minDistance = process(str, i + 1);
            dp[i + 1] = process(str, i + 1);
            dp[i] = dp[i + 1];
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
//                minDistance += process(str, i + 2);
                dp[i + 2] = process(str, i + 2);
                dp[i] += dp[i + 2];
            }
        }
        return dp[i];
    }

    public static int dpWay1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else if (str[i] == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < N) {
                    dp[i] += dp[i + 2];
                }
            } else if (str[i] == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                    dp[i] += dp[+2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(
                arr[L] + s(arr, L + 1, R),
                arr[R] + s(arr, L, R - 1)
        );
    }

    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.max(
                f(arr, i + 1, j),
                f(arr, i, j - 1)
        );
    }

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1),
                s(arr, 0, arr.length - 1)
        );
    }

    public static int test1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp1 = new int[N][N];
        int[][] dp2 = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (i == j) {
                    dp1[i][j] = arr[i];
                } else {
                    if (i + 1 < N) {
                        dp1[i][j] = arr[i] + dp2[i + 1][j];
                    }
                    if (j - 1 >= 0) {
                        dp1[i][j] = Math.max(arr[j] + dp2[i][j - 1], dp1[i][j]);
                    }
                }
                if (i == j) {
                    dp2[i][j] = 0;
                } else if (i + 1 < N && j - 1 >= 0) {
                    dp2[i][j] = Math.max(dp1[i + 1][j], dp1[i][j - 1]);
                }
            }
        }
        return Math.max(dp1[0][N - 1], dp2[0][N - 1]);
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return test1(arr);
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 5, 19, 29, 80, 4};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
    }

}
