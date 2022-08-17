package a700;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 * 特殊的二进制序列是具有以下两个性质的二进制序列：
 * <p>
 * 0 的数量与 1 的数量相等。
 * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
 * 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
 * <p>
 * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "11011000"
 * 输出: "11100100"
 * 解释:
 * 将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
 * 这是在进行若干次操作后按字典序排列最大的结果。
 * 说明:
 * <p>
 * S 的长度不超过 50。
 * S 保证为一个满足上述定义的特殊 的二进制序列。
 */
class Solution761 {
    public String makeLargestSpecial(String s) {
        if(s.length()<=2){
            return s;
        }
        int cnt= 0, left = 0;
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
                if (cnt== 0) {
                    subList.add("1" + this.makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }
        Collections.sort(subList, (a, b) -> b.compareTo(a));
        StringBuilder ans = new StringBuilder();
        for (String sub : subList) {
            ans.append(sub);
        }
        return ans.toString();
    }
}

public class H761makeLargestSpecial {
    public static void main(String[] args) {
        String S = "11011000";
        Solution761 solve = new Solution761();
        String result = solve.makeLargestSpecial(S);
        System.out.println(result);

    }
}
