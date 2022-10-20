package a700;

public class M779kthGrammar {
    static class Solution {
        public int kthGrammar(int n, int k) {
            if (n == 1) {
                return 0;
            }
            if (k == 1) {
                return 0;
            }
            int parentG = kthGrammar(n - 1, (k + 1) / 2);
            return parentG == 0 ? (k % 2 == 0 ? 1 : 0) : (k % 2 == 0 ? 0 : 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int result = solution.kthGrammar(2, 2);
//        int result = solution.kthGrammar(2, 1);
        int result = solution.kthGrammar(1, 1);
        System.out.println(result);
    }
}
