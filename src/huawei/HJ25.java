package huawei;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * HJ25 数据分类处理
 * <p>
 * 描述
 * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
 * <p>
 * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
 * <p>
 * 数据范围：
 * 1
 * ≤
 * �
 * ,
 * �
 * ≤
 * 100
 * <p>
 * 1≤I,R≤100  ，输入的整数大小满足
 * 0
 * ≤
 * �
 * �
 * �
 * ≤
 * 2
 * 31
 * −
 * 1
 * <p>
 * 0≤val≤2
 * 31
 * −1
 * 输入描述：
 * ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~(2^31)-1，序列个数不限
 * <p>
 * 输出描述：
 * ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：
 * <p>
 * I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
 * <p>
 * 按R<i>从小到大的顺序:
 * <p>
 * (1)先输出R<i>；
 * <p>
 * (2)再输出满足条件的I的个数；
 * <p>
 * (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
 * <p>
 * (4)最后再输出I。
 * <p>
 * 附加条件：
 * <p>
 * (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
 * <p>
 * (2)如果没有满足条件的I，对应的R<i>不用输出
 * <p>
 * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
 * <p>
 * <p>
 * <p>
 * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
 * <p>
 * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
 * <p>
 * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
 * <p>
 * 说明：
 * <p>
 * 30----后续有30个整数
 * <p>
 * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
 * <p>
 * 6--- 存在6个包含3的I
 * <p>
 * 0--- 123所在的原序号为0
 * <p>
 * 123--- 123包含3，满足条件
 * <p>
 * 示例1
 * 输入：
 * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
 * 5 6 3 6 3 0
 * 复制
 * 输出：
 * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 * 复制
 * 说明：
 * 将序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）排序去重后，可得0,3,6。
 * 序列I没有包含0的元素。
 * 序列I中包含3的元素有：I[0]的值为123、I[3]的值为453、I[7]的值为3、I[9]的值为453456、I[13]的值为453、I[14]的值为123。
 * 序列I中包含6的元素有：I[1]的值为456、I[2]的值为786、I[4]的值为46、I[8]的值为665、I[9]的值为453456、I[11]的值为456、I[12]的值为786。
 * 最后按题目要求的格式进行输出即可。
 */
public class HJ25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs1 = sc.nextLine().split(" ");
        Integer n1 = Integer.parseInt(strs1[0]);

        String[] strs2 = sc.nextLine().split(" ");
        Integer n2 = Integer.parseInt(strs2[0]);
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int n1 = Integer.parseInt(o1);
                int n2 = Integer.parseInt(o2);
                return n1 - n2;
            }
        });
        for (int i = 1; i < strs2.length; i++) {
            set.add(strs2[i]);
        }
        StringBuilder res = new StringBuilder();
        int alllen = 0;
        for (String s : set) {
            StringBuilder sb = new StringBuilder();
            int len = 0;
            for (int i = 1; i < strs1.length; i++) {
                if (strs1[i].contains(s)) {
                    sb.append((i - 1) + " " + strs1[i] + " ");
                    len++;
                    alllen += 2;
                }
            }
            if (len > 0) {
                alllen += 2;
                res.append(s + " ").append(len + " ").append(sb);
            }
        }
        System.out.println(alllen + " " + res);


    }
}
