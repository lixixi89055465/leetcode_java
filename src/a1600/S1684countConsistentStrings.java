package a1600;

/**
 * 1684. 统计一致字符串的数目
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 *
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 *
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 */
public class S1684countConsistentStrings {
    protected static class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int mast = 0;
            for (int i = 0; i < allowed.length(); i++) {
                mast |= (1 << (allowed.charAt(i) - 'a'));
            }
            int ans=0;
            for (int i = 0; i <words.length ; i++) {
                int j=0;
                for (j = 0; j < words[i].length(); j++) {
                    if(((1<<(words[i].charAt(j)-'a'))&mast)==0){
                        break;
                    }
                }
                if(j==words[i].length()){
                    ans+=1;
                }

            }
            return ans;
        }
    }

    public static void main(String[] args) {

        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        Solution solution = new Solution();
        int result = solution.countConsistentStrings(allowed, words);
        System.out.println(result);
    }
}
