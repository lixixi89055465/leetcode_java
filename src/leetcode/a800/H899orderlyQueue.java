package leetcode.a800;

import java.util.Arrays;

/**
 * 899. 有序队列
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * <p>
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 * <p>
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= S.length <= 1000
 * s 只由小写字母组成。
 */
class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            StringBuilder sb = new StringBuilder(s);
            String smallSb = s;
            for (int i = 0; i < s.length() - 1; i++) {
                sb = sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                if (sb.toString().compareTo(smallSb) < 0) {
                    smallSb=sb.toString();
                }
            }
            return smallSb;
        }
        char[] schar = s.toCharArray();
        Arrays.sort(schar);
        return new String(schar);
    }
}

public class H899orderlyQueue {
    public static void main(String[] args) {
        Solution solve = new Solution();
//        String s = "cba";
//        int k = 1;

//        String s = "baaca";
//        int k = 3;
        String s = "nhtq";
        int k = 1;
        String result = solve.orderlyQueue(s, k);
        System.out.println(result);
    }
}
