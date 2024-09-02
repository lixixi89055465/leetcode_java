package huawei.OD24_09;

import java.util.*;

/**
 * 华为OD机试统一考试D卷C卷 - 英文输入法
 * 题目描述
 * 主管期望你来实现英文输入法单词联想功能。需求如下：
 * <p>
 * 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列，
 * 如果联想不到，请输出用户输入的单词前缀。
 * 注意：
 * <p>
 * 英文单词联想时，区分大小写
 * 缩略形式如”don’t”，判定为两个单词，”don”和”t”
 * 输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
 * 输入描述
 * 输入为两行。
 * <p>
 * 首行输入一段由英文单词word和标点符号组成的语句str；
 * <p>
 * 接下来一行为一个英文单词前缀pre。
 * <p>
 * 0 < word.length() <= 20
 * 0 < str.length <= 10000
 * 0 < pre <= 20
 * 输出描述
 * 输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割
 * <p>
 * 输入
 * <p>
 * I love you
 * <p>
 * He
 * <p>
 * 输出
 * <p>
 * He
 * <p>
 * 说明
 * <p>
 * 从用户已输入英文语句”I love you”中提炼出“I”、“love”、“you”三个单词，接下来用户输入“He”，从已输入信息中无法联想到任何符合要求的单词，因此输出用户输入的单词前缀。
 * <p>
 * 输入
 * <p>
 * The furthest distance in the world, Is not between life and death, But when I stand in front of you, Yet you don’t know that I love you.
 * <p>
 * f
 * <p>
 * 输出
 * <p>
 * front furthest
 * <p>
 * 说明
 * <p>
 * 从用户已输入英文语句”The furthestdistance in the world, Is not between life and death, But when I stand in frontof you, Yet you dont know that I love you.”中提炼出
 * <p>
 * 作者：不上岸不改名！
 * 链接：https://www.nowcoder.com/discuss/619836120829792256
 * 来源：牛客网
 */
public class ywsrf {
    public static void main(String[] args) {
        //        Scanner sc = new Scanner(System.in);
//        String input= sc.nextLine();
//        String pres=sc.nextLine();
        String input = "The furthest distance in the world, Is not between " +
                "life and death, But when I stand in front of you, " +
                "Yet you don’t know that I love you.\n";
        String[] split = input.split(" |,|\\.");
        String pre = "f";
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            int i1 = split[i].indexOf(pre);
            if (i1 == 0 && split[i].length() > 0) {
                strList.add(split[i]);
            }
        }
        Collections.sort(strList);
        for (String s : strList) {
            System.out.print(s+ " ");
        }
    }
}
