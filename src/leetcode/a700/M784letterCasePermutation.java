package leetcode.a700;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution784 {
    public List<String> letterCasePermutation(String s) {
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                m++;
            }
        }
        ArrayList<String> ans = new ArrayList<>((1 << m));
        for (int mask = 0; mask < (1 << m); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, k = 0; j < s.length(); j++) {
                int a = mask & (1 << k);
                System.out.println(a);
                if (Character.isLetter(s.charAt(j)) && (mask & (1 << k++)) != 0) {
                    sb.append(Character.toUpperCase(s.charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(s.charAt(j)));
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}

public class M784letterCasePermutation {
    public static void main(String[] args) {
//        String[]str={"a1b2","a1B2","A1b2","A1B2"};
        String str = "a1b2";
        Solution784 solve = new Solution784();
        List<String> result = solve.letterCasePermutation(str);
        for (String s : result) {
            System.out.println(s + ",");
        }

    }
}
