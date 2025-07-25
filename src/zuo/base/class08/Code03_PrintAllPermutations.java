package zuo.base.class08;

import utils.RandomUtils;

import java.util.ArrayList;

/**
 * 打印一个字符串的全部排列
 * 打印一个字符串的全部排列，要求不要出现重复的排列
 */
public class Code03_PrintAllPermutations {
    public static ArrayList<String> Permutation2(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process01(chs, 0, res);
        res.sort(null);
        return res;
    }

    private static void process01(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        //使用
        process01(chs, i + 1, res);
        //不使用
        char tmp = chs[i];
        chs[i] = 0;
        process01(chs, i + 1, res);
        chs[i] = tmp;


    }

    public static ArrayList<String> Permutation(String str) {
//		ArrayList<String> res = new ArrayList<>();
//		if (str == null || str.length() == 0) {
//			return res;
//		}
//		char[] chs = str.toCharArray();
//		process(chs, 0, res);
//		res.sort(null);
//		return res;
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        res.sort(null);
        return res;
    }

    public static void process(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            if (!visit[chs[j] - 'a']) {
                visit[chs[j] - 'a'] = true;
                RandomUtils.swap(chs, i, j);
                process(chs, i + 1, res);
                RandomUtils.swap(chs, i, j);
            }

        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "abca";
        ArrayList<String> result = Permutation(str);
        result.forEach(e -> {
            System.out.println(e);
        });

    }

}
