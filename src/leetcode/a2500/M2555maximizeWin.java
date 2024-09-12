package leetcode.a2500;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/11 23:17
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 2555. 两个线段获得的最多奖品
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，它按照 非递减 顺序排列，其中 prizePositions[i] 是第 i 件奖品的位置。数轴上一个位置可能会有多件奖品。再给你一个整数 k 。
 * <p>
 * 你可以同时选择两个端点为整数的线段。每个线段的长度都必须是 k 。你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。
 * <p>
 * 比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
 * 请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：prizePositions = [1,1,2,2,3,3,5], k = 2
 * 输出：7
 * 解释：这个例子中，你可以选择线段 [1, 3] 和 [3, 5] ，获得 7 个奖品。
 * 示例 2：
 * <p>
 * 输入：prizePositions = [1,2,3,4], k = 0
 * 输出：2
 * 解释：这个例子中，一个选择是选择线段 [3, 3] 和 [4, 4] ，获得 2 个奖品。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prizePositions.length <= 105
 * 1 <= prizePositions[i] <= 109
 * 0 <= k <= 109
 * prizePositions 有序非递减。
 */
public class M2555maximizeWin {
    private static class Solution {
        public int maximizeWin1(int[] prizePositions, int k) {
            int n = prizePositions.length;
            int[] dp = new int[n + 1];
            int ans = 0;
            for (int left = 0, right = 0; right < n; right++) {
                while (prizePositions[right] - prizePositions[left] > k) {
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
                dp[right + 1] = Math.max(dp[right], right - left + 1);
            }
            return ans;
        }

        public int maximizeWin(int[] prizePositions, int k) {
            int res = 0;
            int left = 0, right = -1;
            int pre = 0;
            List<int[]> arr = new ArrayList<>();
            while (right + 1 < prizePositions.length && left <= right + 1) {
                while (right + 1 < prizePositions.length && prizePositions[right + 1] - prizePositions[left] <= k) {
                    right++;
                }
                if (right + 1 > pre && prizePositions[right] - prizePositions[left] == k) {
//                    res += (1 + right - Math.max(pre, left));
                    int[] subRes = {left, right};
                    arr.add(subRes);
                    pre = right + 1;
                }
                left++;
            }
            if (arr == null || arr.size() < 2) {
                return 0;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < arr.size() - 1; i++) {
                int[] arri = arr.get(i);
                for (int j = i + 1; j < arr.size(); j++) {
                    int[] arrj = arr.get(j);
                    res = Math.max(res, arri[1] - arri[0] + arrj[1] - arrj[0] + 2 + (arrj[0] > arri[1] ? 0 : arrj[0] - arri[1] - 1));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] prizePositions = {1, 1, 2, 2, 3, 3, 5};
//        int k = 2;

//        int[] prizePositions = {1, 2, 3, 4};
//        int k = 0;
        int[] prizePositions = {2616, 2618, 2620, 2621, 2626, 2635, 2657, 2662, 2662, 2669, 2671, 2693, 2702, 2713, 2714, 2718, 2730, 2731, 2750, 2756, 2772, 2773, 2775, 2785, 2795, 2805, 2811, 2813, 2816, 2823, 2824, 2824, 2826, 2830, 2833, 2857, 2885, 2898, 2910, 2919, 2928, 2941, 2942, 2944, 2965, 2967, 2970, 2973, 2974, 2975, 2977, 3002, 3007, 3012, 3042, 3049, 3078, 3084, 3089, 3090, 3094, 3097, 3114, 3124, 3125, 3125, 3144, 3147, 3148, 3174, 3197, 3255, 3262, 3288, 3291, 3316, 3320, 3322, 3331, 3342, 3378, 3412, 3412, 3416, 3420, 3427, 3428, 3446, 3452, 3472, 3479, 3483, 3488, 3500, 3516, 3522, 3531, 3532, 3540, 3540, 3544, 3557, 3570, 3580, 3592, 3597, 3597, 3601, 3615, 3631, 3640, 3645, 3673, 3677, 3681, 3683, 3685, 3718, 3738, 3746, 3758, 3769, 3797, 3802, 3815, 3832, 3839, 3851, 3864, 3888, 3889, 3901, 3902, 3910, 3913, 3933, 3940, 3961, 3974, 3988, 4003, 4013, 4019, 4023, 4026, 4047, 4060, 4065, 4072, 4073, 4082, 4084, 4109, 4132, 4139, 4143, 4145, 4146, 4155};
        int k = 6641;
        int res = solve.maximizeWin1(prizePositions, k);

        System.out.println(res);
    }
}
