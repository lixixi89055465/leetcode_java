package ZJ;

import java.util.ArrayList;
import java.util.List;

public class ZJ22generateParenthesis {
    private static class Solution {
        public List<String> generateParenthesis(int n) {
            int left = n;
            int right = n;
            ArrayList<String> res = new ArrayList<>();
            generate(res, "", left, right);
            return res;
        }

        private void generate(List<String> res, String pre, int left, int right) {
            if (left == 0 && right == 0) {
                res.add(pre);
                return;
            }
            if (left == right) {
                generate(res, pre + "(", left - 1, right);
            }
            if (left == 0 && right > 0) {
                generate(res, pre + ")", left, right - 1);
            }
            if (0 < left && left < right) {
                generate(res, pre + "(", left - 1, right);
                generate(res, pre + ")", left, right - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int n = 3;
        System.out.println(solve.generateParenthesis(n));
    }
}
