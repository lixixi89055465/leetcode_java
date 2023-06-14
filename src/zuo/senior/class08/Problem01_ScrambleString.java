package zuo.senior.class08;

public class Problem01_ScrambleString {
    public static boolean sameTypeSameNumber(char[] str1, char[] str2) {
        if (str1.length != str2.length) {
            return false;
        }
        int[] map = new int[256];
        for (int i = 0; i < str1.length; i++) {
            map[str1[i]]++;
        }
        for (int i = 0; i < str2.length; i++) {
            if (--map[str2[i]] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isScramble1(String s1, String s2) {
        if ((s1 == null && s2 != null) || (s2 == null && s1 != null)) {
            return false;
        }
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1.equals(s2)) {
            return true;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int N = s1.length();
        return process(str1, str2, 0, 0, N);
    }

    private static boolean process(char[] str1, char[] str2, int L1, int L2, int size) {
        if (size == 1) {
            return str1[L1] == str2[L2];
        }
        for (int leftPart = 1; leftPart < size; leftPart++) {
            if (
                    process(str1, str2, L1, L2, leftPart)
                            &&
                            process(str1, str2, L1 + leftPart, L2 + leftPart, size - leftPart)
                            ||
                            process(str1, str2, L1, L2 + size - leftPart, leftPart)
                                    &&
                                    process(str1, str2, L1 + leftPart, L2, size - leftPart)) {
                return true;
            }
        }
        return false;
    }

    public static boolean dpCheck(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int N = str1.length;
        boolean[][][] dp = new boolean[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j][1] = true;
                } else {
                    dp[i][j][1] = false;
                }
            }
        }


        for (int size = 2; size <= N; size++) {
            for (int L1 = 0; L1 < N - size; L1++) {
                for (int L2 = 0; L2 < N - size; L2++) {
                    for (int leftPart = 1; leftPart < size; leftPart++) {
                        if (dp[L1][L2][leftPart] && dp[L1 + leftPart][L2 + leftPart][size - leftPart]
                                ||
                                dp[L1][L2 + size - leftPart][leftPart] && dp[L1 + leftPart][L2][size - leftPart]) {
                            dp[L1][L2][size] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][N];
    }

    public static void main(String[] args) {

    }
}
