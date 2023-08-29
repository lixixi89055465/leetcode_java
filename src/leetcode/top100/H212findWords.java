package leetcode.top100;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import javax.swing.table.DefaultTableCellRenderer;
import java.util.List;

/**
 * @PackageName:leetcode.top100
 * @Date 2023/8/29 17:53
 * @Description: https://leetcode.cn/problems/word-search-ii/
 * 212. 单词搜索 II
 * 提示
 * 困难
 * 787
 * 相关企业
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 示例 1：
 * <p>
 * 输入：board =
 * [
 * ["o","a","a","n"],
 * ["e","t","a","e"],
 * ["i","h","k","r"],
 * ["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 */
public class H212findWords {
    private static class Solution {
        private class DictNode {
            private boolean isEnd = false;
            DictNode[] nexts = null;

            public DictNode() {
                this.nexts = new DictNode[26];
            }
        }

        private class DTree {
            public DictNode root = new DictNode();

            public void add(String word) {
                char[] chs = word.toCharArray();
                DictNode curNode = root;
                for (int i = 0; i < chs.length; i++) {
                    int curIndex = chs[i] - 'a';
                    if (curNode.nexts[curIndex] == null) {
                        curNode.nexts[curIndex] = new DictNode();
                    }
                    curNode = curNode.nexts[curIndex];
                }
                curNode.isEnd = true;
            }

            public boolean isContain(String word) {
                return false;
            }
        }

        public List<String> findWords(char[][] board, String[] words) {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        /**
         * board =
         *  * [
         *  * ["o","a","a","n"],
         *  * ["e","t","a","e"],
         *  * ["i","h","k","r"],
         *  * ["i","f","l","v"]],
         *  * words = ["oath","pea","eat","rain"]
         *  * 输出：["eat","oath"]
         */
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        solve.findWords(board, words);
    }
}
