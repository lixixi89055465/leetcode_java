package test01;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年09月12日 18:37
 * 项目名称: leetcode_java
 * 文件名称: Solve03
 * 文件描述: @Description:
 * site:
 */
public class Solve03 {

    private static class Solution {
        public int closestTarget(String[] words, String target, int startIndex) {
            if (words == null || words.length == 0) {
                return -1;
            }
            int res = 0;
            int n = words.length;
            for (int i = 0; i < words.length; i++) {
                if (words[(startIndex + i) % n].equals(target)) {
                    return res;
                }
                if (words[(startIndex - i+n) % n].equals(target)) {
                    return res;
                }
                res++;
            }
            return -1;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
//        String[] words = {"hello", "i", "am", "leetcode", "hello"};
//        String target = "hello";
//        int startIndex = 1;
//            String[] words = {"a", "b", "leetcode"};
//            String target = "leetcode";
//            int startIndex = 0;
            String []words = {"i","eat","leetcode"};
            String target = "ate";
            int startIndex = 0;
            int i = solution.closestTarget(words, target, startIndex);
            System.out.println(i);
        }
    }
}
