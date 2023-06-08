package test;

import java.util.ArrayList;
import java.util.List;

public class test6 {
    public static String ambiguousCoordinates(String s) {
        // write code here
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            List<String> strs1 = getSubString(s, 0, i);
            List<String> strs2 = getSubString(s, i + 1, chs.length - 1);
            for (int j = 0; j < strs1.size(); j++) {
                for (int k = 0; k < strs2.size(); k++) {
                    sb.append(strs1.get(j));
                    sb.append(",");
                    sb.append(strs2.get(k));
                }
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static List<String> getSubString(String chs, int left, int right) {
        ArrayList<String> result = new ArrayList<>();
        result.add(chs.substring(left,right+1));
        for (int i = left + 1; i <= right; i++) {
            result.add(chs.substring(left, i) + "." + chs.substring(i, right + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(ambiguousCoordinates(s));
    }
}
