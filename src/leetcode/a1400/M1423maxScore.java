package leetcode.a1400;

public class M1423maxScore {
    private static class Solution {
        public int maxScore(int[] cardPoints, int k) {
            if (cardPoints == null) {
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < cardPoints.length; i++) {
                sum += cardPoints[i];
            }
            if (cardPoints.length <= k) {
                return sum;
            }

            int rest = cardPoints.length - k;
            int subSum = 0;
            for (int i = 0; i < rest; i++) {
                subSum += cardPoints[i];
            }
            int res = subSum;
            for (int i = rest; i < cardPoints.length; i++) {
                subSum += cardPoints[i] - cardPoints[i - rest];
                res = Math.min(res, subSum);
            }
            return sum-res;
        }
    }

    public static void main(String[] args) {
        int[] cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        Solution solution = new Solution();
        int res = solution.maxScore(cardPoints, k);
        System.out.println(res);
    }
}
