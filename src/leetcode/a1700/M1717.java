package leetcode.a1700;

import leetcode.a1200.M1233;

import java.util.Stack;

/**
 * 1717. 删除子字符串的最大得分
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 * <p>
 * 删除子字符串 "ab" 并得到 x 分。
 * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 * 删除子字符串"ba" 并得到 y 分。
 * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cdbcbbaaabab", x = 4, y = 5
 * 输出：19
 * 解释：
 * - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
 * - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
 * - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
 * - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
 * <p>
 * <p>
 * cdbcabab
 * 总得分为 5 + 4 + 5 + 5 = 19 。
 * 示例 2：
 * <p>
 * 输入：s = "aabbaaxybbaabb", x = 5, y = 4
 * 输出：20
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * 1 <= x, y <= 104
 * s 只包含小写英文字母。
 */
public class M1717 {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            s = s.replace("a", "B");
            s = s.replace("b", "A");
            int tmp = x;
            x = y;
            y = tmp;
        } else {
            s = s.replace("a", "A");
            s = s.replace("b", "B");
        }
        char[] chs = s.toCharArray();
        int res = 0;
        int Anum = 0, Bnum = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'A') {
                if (Bnum > 0) {
                    res += y;
                    Bnum--;
                } else {
                    Anum++;
                }
            } else if (chs[i] == 'B') {
                Bnum++;
            } else {
                res = res + (Anum > Bnum ? Bnum : Anum) * x;
                Anum = 0;
                Bnum = 0;
            }
        }
        res = res + (Anum > Bnum ? Bnum : Anum) * x;
        return res;
    }


    public static void main(String[] args) {
        M1717 solve = new M1717();
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;
//        String s = "aabbaaxybbaabb";
//        int x = 5, y = 4;
//        String s = "aabbrtababbabmaaaeaabeawmvaataabnaabbaaaybbbaabbabbbjpjaabbtabbxaaavsmmnblbbabaeuasvababjbbabbabbasxbbtgbrbbajeabbbfbarbagha";
//        int x = 8484, y = 4096;
//        String s = "aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha";
//        int x = 1926, y = 4320;

        int res = solve.maximumGain(s, x, y);
        System.out.println(res);
    }
}
