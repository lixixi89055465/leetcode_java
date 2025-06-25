package leetcode.a1400;

/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 1423. 可获得的最大点数
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * 示例 2：
 * <p>
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * 示例 3：
 * <p>
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * 示例 4：
 * <p>
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * 示例 5：
 * <p>
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 */
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
            if (k > cardPoints.length) {
                return sum;
            }
            int subSum = 0;
            for (int i = 0; i < k; i++) {
                subSum += cardPoints[i];
            }
            int res = subSum;
            int n = cardPoints.length;
            for (int i = 0; i < k; i++) {
                subSum -= cardPoints[k - i - 1];
                subSum += cardPoints[n - i - 1];
                res = Math.max(res, subSum);
            }
            return res;
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
