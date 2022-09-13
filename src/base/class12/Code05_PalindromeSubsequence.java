package base.class12;

public class Code05_PalindromeSubsequence {
    public static int lsce(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }

        }
        return dp[str1.length-1][str2.length-1];
    }

    public static void main(String[] args) {
        String str1 = "fjk1ld23sj4flks";
//        j1d234f
//        j1d234f
        String str2 = "gjd1fgj2kd2s34jgkldjf";
        System.out.println(lsce(str1.toCharArray(), str2.toCharArray()));
    }
}
