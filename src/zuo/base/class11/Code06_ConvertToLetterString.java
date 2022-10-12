package zuo.base.class11;

import java.util.ArrayList;
import java.util.HashSet;

public class Code06_ConvertToLetterString {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    private static void process(char[] str, int index, ArrayList<String> res) {
        if (index == str.length) {
            res.add(String.valueOf(str));
            return;
        }
        for (int i = index; i < str.length; i++) {
            swap(str, index, i);
            process(str, index + 1, res);
            swap(str, i, index);
        }
    }

    private static void swap(char[] str, int index, int i) {
        char tmp = str[index];
        str[index] = str[i];
        str[i] = tmp;
    }

    public static HashSet<String> permutation2(String str) {
        HashSet<String> res = new HashSet<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process2(chs, 0, res);
        return res;
    }

    private static void process2(char[] str, int index, HashSet<String> res) {
        if (index == str.length) {
            res.add(String.valueOf(str));
            return;
        }
        for (int i = index; i < str.length; i++) {
            swap(str, index, i);
            process2(str, index + 1, res);
            swap(str, i, index);
        }
    }

    public static ArrayList<String> permutationNoRepeat(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process3(chs, 0, res);
        return res;

    }

    private static void process3(char[] str, int index, ArrayList<String> res) {
        if (index == str.length) {
            res.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int j = index; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, index, j);
                process3(str, index + 1, res);
                swap(str, index, j);
            }
        }

    }

    public static void main(String[] args) {
//        ArrayList<String> abc = permutation("abc");
//        ArrayList<String> abc = permutationNoRepeat("abbc");
        ArrayList<String> abc = permutationNoRepeat("abb");
        abc.forEach(System.out::println);
    }

}
//A:1 , B:2 C:3 D:4 E:5 F:6