package leetcode.a900;

public class H906superpalindromesInRange {
    private static class Solution {
        public int superpalindromesInRange(String left, String right) {
            Long L = Long.parseLong(left);
            Long R = Long.parseLong(right);
            int res = 0;
            for (long i = (int) Math.sqrt(L); i <= Math.sqrt(R); i++) {
                if (isLinedrome(i) && isLinedrome(i * i)) {
                    res++;
                }
            }
            return res;
        }

        private boolean isLinedrome(long value) {
            long temp = value;
            long reverse = 0;
            while (value > 0) {
                reverse += (value % 10);
                reverse*=10;
                value /= 10;
            }
            reverse/=10;
            return reverse == temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String L = "4", R = "1000";
//        String L = "40000000000000000", R = "50000000000000000";
//        String L = "9944094036", R = "431375128285413";
        System.out.println(solution.superpalindromesInRange(L, R));

    }
}
