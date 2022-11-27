package leetcode.a900;


import java.util.ArrayList;
import java.util.List;

/**
 * 902. 最大为 N 的数字组合
 * 给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
 * <p>
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 * <p>
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * 示例 3:
 * <p>
 * 输入：digits = ["7"], n = 8
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 9
 * digits[i].length == 1
 * digits[i] 是从 '1' 到 '9' 的数
 * digits 中的所有值都 不同
 * digits 按 非递减顺序 排列
 * 1 <= n <= 109
 */
public class H902atMostNGivenDigitSet {
    static class Solution {
        public int atMostNGivenDigitSet(String[] digits, int n) {
            int a = n;
            int wei = 0;
            int sum = 0;
            List<Integer> weisum=new ArrayList<Integer>();
            while (a/10 > 0) {
                wei += 1;
                sum += (int) Math.pow(digits.length, wei );
                a /= 10;
                int weishu=a%10;
                int w=0;
                for (int i = 0; i < digits.length; i++) {
                    if(weishu>digits[i].indexOf(0)-'a'){
                        break;
                    }
                    w+=1;
                }

            }
            return sum;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] digits = new String[]{"1", "3", "5", "7"};
        int n = 100;
        int result = solution.atMostNGivenDigitSet(digits, n);
        System.out.println(result);
    }
}
