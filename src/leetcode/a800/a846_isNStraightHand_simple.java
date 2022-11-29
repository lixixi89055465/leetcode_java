package leetcode.a800;

/**
 * 846. 一手顺子
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *
 *
 * 提示：
 *
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 *
 *
 * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class a846_isNStraightHand_simple {
    public static boolean isNStraightHand(int[] hand, int w) {
        if (hand.length % w != 0)
            return false;
        int[] array = new int[w];
        for (int i : hand) {
            array[i % w]++;
        }
        for (int i = 0; i < w - 1; i++) {
            //若是顺子，array的每一元素理应是相等的
            if (array[i] != array[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 11};
        int groupSize = 3;
        boolean result = isNStraightHand(hand, groupSize);
        System.out.println(result);
    }
}
