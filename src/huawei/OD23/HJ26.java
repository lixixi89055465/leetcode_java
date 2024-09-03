package huawei.OD23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * HJ26 字符串排序
 * <p>
 * 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * <p>
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * <p>
 * 如，输入： Type 输出： epTy
 * <p>
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * <p>
 * 如，输入： BabA 输出： aABb
 * <p>
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * <p>
 * <p>
 * 如，输入： By?e 输出： Be?y
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述：
 * 输入字符串
 * 输出描述：
 * 输出字符串
 * 示例1
 * 输入：
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 复制
 * 输出：
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class HJ26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        ArrayList<Character> res = new ArrayList<>();
        for (int i = 0; i < chs.length; i++) {
            if (Character.isLetter(chs[i])) {
                res.add(chs[i]);
            }
        }
        res.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int v1 = o1 >= 'a' && o1 <= 'z' ? o1 - 'a' : o1 - 'A';
                int v2 = o2 >= 'a' && o2 <= 'z' ? o2 - 'a' : o2 - 'A';
                return v1 - v2;
            }
        });
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < chs.length; i++) {
            if (Character.isLetter(chs[i])) {
                sb.append(res.get(start++));
            } else {
                sb.append(chs[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
