package base.class11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Code02_PrintAllSubsequence {
    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        ArrayList<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }

    private static void process1(char[] str, int index, ArrayList<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        process1(str, index + 1, ans, path + str[index]);
        process1(str, index + 1, ans, path);
    }

    public static List<String> subsNoRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<>();
        process2(str, 0, set, path);
        List<String> ans = new ArrayList<>();
        for (String cur : set) {
            ans.add(cur);
        }
        return ans;
    }

    private static void process2(char[] str, int index, HashSet<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        process2(str, index + 1, ans, path + str[index]);
        process2(str, index + 1, ans, path);
    }


    public static void main(String[] args) {
        List<String> ans = subs("abc");
        ans.forEach(System.out::println);
    }

}
