package leetcode.a400;

/**
 * 481. 神奇字符串
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 * <p>
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
 * <p>
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：3
 * 解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 */
public class M481magicalString {
    static class Solution481 {
        public int magicalString(int n) {
            char[] str = new char[n+1];
            str[0] = '1';
            int start = 0;
            boolean invert = false;
            for (int i = 0; i < n; i++) {
                if (str[start] == '1') {
                    str[i] = invert ? '2' : '1';
                } else {
                    str[i++] = invert ? '2' : '1';
                    str[i] = invert ? '2' : '1';
                }
                start++;
                invert=!invert;
            }
            int ans=0;
            for (int i = 0; i < n; i++) {
                if(str[i]=='1') {
                    ans += 1;
                }
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        Solution481 solution= new Solution481();
        int result=solution.magicalString(1);
        System.out.println(result);
    }
}
