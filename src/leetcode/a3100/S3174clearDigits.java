package leetcode.a3100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/5 10:17
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class S3174clearDigits {
    private static class Solution {
        public String clearDigits(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            char[] chs = s.toCharArray();
            Deque<Character> queue = new LinkedList<Character>();
            queue.push(chs[0]);
            for (int i = 1; i < chs.length; i++) {
                if (!queue.isEmpty() && Character.isDigit(chs[i])) {
                    queue.pop();
                    continue;
                }
                queue.push(chs[i]);
            }
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                sb.append(queue.pollLast());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        String s = "cb34";
        String s ="abc";
        Solution solve = new Solution();
        String res = solve.clearDigits(s);
        System.out.println(res);

    }
}
