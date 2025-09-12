package zuo.intermediate.class08;

/**
 * 给定一个全是小写字母的字符串str，删除多余字符，使得每种字符只保留一个，并让
 * 最终结果字符串的字典序最小
 * 【举例】
 * str = "acbc"，删掉第一个'c'，得到"abc"，是所有结果字符串中字典序最小的。
 * str = "dbcacbca"，删掉第一个'b'、第一个'c'、第二个'c'、第二个'a'，得到"dabc"，
 * 是所有结 果字符串中字典序最小的。
 */
public class Problem06_RemoveDuplicateLeetter {
    public static String remove(String str) {
//        if (str == null || str.length() == 0) {
//            return str;
//        }
//        int[] map = new int[256];
//        for (int i = 0; i < str.length(); i++) {
//            map[str.charAt(i)]++;
//        }
//        int minASCIIndex = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (--map[str.charAt(i)] == 0) {
//                break;
//            } else {
//                minASCIIndex = str.charAt(minASCIIndex) < str.charAt(i) ? minASCIIndex : i;
//            }
//        }
//        return str.charAt(minASCIIndex) +
//                remove(
//                        str.substring(minASCIIndex + 1).replaceAll(String.valueOf(str.charAt(minASCIIndex)), "")
//                );
        if (str == null || str.length() == 0) {
            return str;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int minAscIIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (--map[str.charAt(i)] == 0) {
                break;
            } else {
                minAscIIndex = str.charAt(i) < str.charAt(minAscIIndex) ? i : minAscIIndex;
            }
        }
        return str.charAt(minAscIIndex) +
                remove(str.substring(minAscIIndex + 1).replaceAll(String.valueOf(str.charAt(minAscIIndex)), ""));
    }

    public static void main(String[] args) {

    }
}
