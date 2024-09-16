package leetcode.a1100;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/16 12:29
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class S1184distanceBetweenBusStops {
    private static class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int n = distance.length;
            int res = 0;
            boolean flag = true;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((start + i) % n == destination) {
                    flag = false;
                }
                if (flag) {
                    res += distance[(start + i) % n];
                }
                sum += distance[i];
            }
            return Math.min(res, sum - res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] distance = {1, 2, 3, 4};
//        int start = 0, destination = 2;
        int start = 0, destination = 3;
        int res = solution.distanceBetweenBusStops(distance, start, destination);
        System.out.println(res);

    }
}
