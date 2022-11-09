package a800;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberDemo {
    // 根据阿里巴巴代码规范，将Pattern设置为全局常量
    // 通过 -?[0-9]+(\\\\.[0-9]+)? 进行匹配是否为数字
//    private static Pattern pattern = Pattern.compile("-?[0-9]+(\\\\.[0-9]+)?");
    private static Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]*");
    
    /**
     * 通过正则表达式判断字符串是否为数字
     * @param str
     * @return
     */
    private static boolean isNumber(String str) {
        // 通过Matcher进行字符串匹配
        Matcher m = pattern.matcher(str);
        // 如果正则匹配通过 m.matches() 方法返回 true ，反之 false
        return m.matches();
    }

    public static void main(String[] args) {
//        String n="12.334";
//        String n="12334";
        String n="00.12";
        System.out.println(isNumber(n));
    }
}