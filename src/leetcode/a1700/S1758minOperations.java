package leetcode.a1700;

public class S1758minOperations {
    protected static class Solution {
        public int minOperations(String s) {
            if (s == null || s.length() <= 1) {
                return 0;
            }
            int ans1 = 0, ans2 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if (i % 2 == 0) {
                        ans1++;
                    } else {
                        ans2++;
                    }

                } else {
                    if (i % 2 == 1) {
                        ans1++;
                    } else {
                        ans2++;
                    }

                }
            }
            return ans1 < ans2 ? ans1 : ans2;
        }
    }

    public static void main(String[] args) {

    }
}
