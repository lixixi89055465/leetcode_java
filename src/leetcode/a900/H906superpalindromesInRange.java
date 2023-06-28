package leetcode.a900;

public class H906superpalindromesInRange {
    private static class Solution {
        public int superpalindromesInRange(String left, String right) {
            long L = Long.parseLong(left);
            long R = Long.parseLong(right);
            int MAGIC = 100000;
            int res = 0;
            for (int i = 0; i < MAGIC; i++) {
                long num = getRealNum(i);
                long num_square = num * num;
                if (num_square > R) {
                    break;
                }
                if (num_square >= L && isLinedrome(num_square)) {
                    res += 1;
                }
            }
            for (int i = 0; i < MAGIC; i++) {
                long num = getRealNum1(i);
                long num_square = num * num;
                if (num_square > R) {
                    break;
                }
                if (num_square >= L && isLinedrome(num_square)) {
                    res += 1;
                }
            }
            return res;
        }

        private long getRealNum1(int i) {
            int value = i;
            int n = 1;
            int res = 0;
            i /= 10;
            while (i > 0) {
                res *= 10;
                res += i % 10;
                i /= 10;
                n *= 10;
            }
            return value * n + res;
        }

        private long getRealNum(int i) {
            int value = i;
            int n = 1;
            int res = 0;
            while (i > 0) {
                res *= 10;
                res += i % 10;
                i /= 10;
                n *= 10;
            }
            return value * n + res;
        }


        private long reverse(long i) {
            long res = 0;
            while (i > 0) {
                res *= 10;
                res += i % 10;
                i /= 10;
            }
            return res;
        }

        private boolean isLinedrome(long value) {
            return value == reverse(value);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String L = "4", R = "1000";
//        String L = "40000000000000000", R = "50000000000000000";
        String L = "9944094036", R = "431375128285413";
        System.out.println(solution.superpalindromesInRange(L, R));

    }
}
