package zuo.intermediate.class02;


/**
 * 一个合法的括号匹配序列有以下定义:
 * ①空串""是一个合法的括号匹配序列
 * ②如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
 * ③如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
 * ④每个合法的括号序列都可以由以上规则生成。
 * 例如: "","()","()()","((()))"都是合法的括号序列
 * 对于一个合法的括号序列我们又有以下定义它的深度:
 * ①空串""的深度是0
 * ②如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为
 * max(x,y) 3、如果"X"的深度是x,那么字符串"(X)"的深度是x+1
 * 例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号
 * 序列,需要你计算出其深度。
 */
public class Problem04_parenthesesDeep {
    public static int maxLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] strs = s.toCharArray();
        int pre = 0;
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && strs[pre] == '(') {
                    dp[i] = strs[pre] == strs[i] ? (dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0)) : 0;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

