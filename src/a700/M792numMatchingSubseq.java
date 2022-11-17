package a700;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 792. 匹配子序列的单词数
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 */
public class M792numMatchingSubseq {
    static protected class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            List[] letterList = new List[26];
            char[] str = s.toCharArray();
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (letterList[index] == null) {
                    letterList[index] = new ArrayList<Integer>();
                }
                letterList[index].add(i);
            }
            int ans = 0;
            for (String word : words) {
                if (isSubWord(word, letterList)) {
                    ans += 1;
                }
            }
            return ans;
        }

        private boolean isSubWord(String word, List<Integer>[] letterList) {
            char[] chars = word.toCharArray();

            int index = -1;
            int lastIndex = 0;
            for (char aChar : chars) {
                index = aChar - 'a';
                List<Integer> list = letterList[index];
                int left = 0, right = list.size() - 1;
                int mid = 0;
                while (left <= right) {
                    mid = left + (right - left) >> 1;
                    if (list.get(mid) < lastIndex) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                if(list.get(mid)>right){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int result = solution.numMatchingSubseq(s, words);
        System.out.println(result);
    }
}
