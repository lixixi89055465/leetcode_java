package leetcode.a000;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月26日 16:44
 * 项目名称: leetcode_java
 * 文件名称: M6
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright: 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 6. Z 字形变换
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */

public class M6 {
    public String convert(String s, int numRows) {
        char[] chs = s.toCharArray();
        StringBuilder[] sList = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sList[i] = new StringBuilder();
        }
        int start = 0;
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < numRows && start < chs.length; j++) {
                sList[j].append(chs[start++]);
            }
            for (int j = numRows - 2; j > 0 && start < chs.length; j--) {
                sList[j].append(chs[start++]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sList.length; i++) {
            sb.append(sList[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        M6 solution = new M6();
//        String s = "PAYPALISHIRING";
//        int numRows = 4;
        String s = "A";
        int numRows = 1;
        String res = solution.convert(s, numRows);
        System.out.println(res);

    }
}
