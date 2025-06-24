package leetcode.a700;

import utils.RandomUtils;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/4 17:18
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 739. 每日温度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class M739dailyTemperatures {
    private static class Solution {
        public int[] dailyTemperatures1(int[] temperatures) {
            LinkedList<Integer> stack = new LinkedList<>();
            int[] answer = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                int temperature = temperatures[i];
                while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperature) {
                    Integer i1 = stack.pollLast();
                    answer[i1] = i - i1;
                }
                stack.offer(i);
            }
            return answer;
        }

        public int[] dailyTemperatures(int[] temperatures) {
            //  * 输入: temperatures = [73,74,75,71,69,72,76,73]
            // * 输出: [1,1,4,2,1,1,0,0]
            if (temperatures == null || temperatures.length == 0) {
                return new int[0];
            }
            Stack<Integer> stack = new Stack<Integer>();
            int[] res = new int[temperatures.length];
            stack.add(0);
            for (int i = 1; i != temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.pop();
                }
                stack.add(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[] temperatures = {72, 74, 75, 71, 69, 72, 76, 73};
//        int[] temperatures = {30,40,50,60};
//        int[] temperatures = {30, 60, 90};
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        Solution solve = new Solution();
        int[] res = solve.dailyTemperatures1(temperatures);
        RandomUtils.printArray(res);
    }
}
