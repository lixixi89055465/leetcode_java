package ZJ;

import java.util.*;

/**
 * 139. 单词拆分
 * 中等
 * 2.2K
 * 相关企业
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * public class Solution {
 * public boolean wordBreak(String s, List<String> wordDict) {
 * Set<String> wordDictSet = new HashSet(wordDict);
 * boolean[] dp = new boolean[s.length() + 1];
 * dp[0] = true;
 * for (int i = 1; i <= s.length(); i++) {
 * for (int j = 0; j < i; j++) {
 * if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
 * dp[i] = true;
 * break;
 * }
 * }
 * }
 * return dp[s.length()];
 * }
 * }
 * <p>
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/word-break/solutions/302471/dan-ci-chai-fen-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ZJ139wordBreak {
    private static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n=s.length()+1;
            boolean[] dp = new boolean[n];
            HashSet<String> set = new HashSet<>(wordDict);

            dp[0]=true;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if(dp[j]&&set.contains(s.substring(j,i))){
                        dp[i]=true;
                        break;
                    }
                }
            }
            return dp[n-1];
        }
    }


    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = Arrays.asList("leet", "code");

        String s = "applepenapple";
        List<String>wordDict = Arrays.asList("apple", "pen");
//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        Solution solve = new Solution();
        System.out.println(solve.wordBreak(s, wordDict));
    }
}
