package leetcode.a3200;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/11/12 8:55
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * <p>
 * 3258. 统计满足 K 约束的子字符串数量 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * <p>
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * <p>
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的
 * 子字符串
 * 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10101", k = 1
 * <p>
 * 输出：12
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "1010101", k = 2
 * <p>
 * 输出：25
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "11111", k = 1
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串都满足 k 约束。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= k <= s.length
 * s[i] 是 '0' 或 '1'。
 */
public class S3258countKConstraintSubstrings {
    private static class Solution {
        public int countKConstraintSubstrings(String s, int k) {
            char[] chs = s.toCharArray();
            int visit = 0;
            for (int i = 0; i < chs.length; i++) {
                int k0 = 0, k1 = 0;
                int end = i;
                while (end < chs.length) {
                    if (chs[end] == '0') {
                        k0++;
                    } else {
                        k1++;
                    }
                    if (k0 <= k || k1 <= k) {
                        visit++;
                    }else{
                        break;
                    }
                    end++;
                }
            }
            return visit;
        }
    }

    public static void main(String[] args) {
//        String s = "1010101";//25
//        int k = 2;
//        String s = "10101";
//        int k = 1;
//        String s = "11111";
//        int k = 1;
        String s = "10101";
        int k = 1;
        Solution solve = new Solution();
        int res = solve.countKConstraintSubstrings(s, k);
        System.out.println(res);


    }
}
