package a700;

/**
 * 754. 到达终点数字
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 *
 * 你可以做一些数量的移动 numMoves :
 *
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * 示例 2:
 *
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 *
 *
 * 提示:
 *
 * -109 <= target <= 109
 * target != 0
 */
public class M754reachNumber {
    protected static class Solution {
        public int reachNumber(int target) {
            if(target<0){
                target=-target;
            }
            int sum=0;
            int ans=0;
            while (sum<target||((sum-target)&1)!=0){
                ans+=1;
                sum+=ans;
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int target = 2;
//        int target = 3;
//        int target = -2;
        int target = 0;
        int result=solution.reachNumber(target);
        System.out.println(result);

    }
}
