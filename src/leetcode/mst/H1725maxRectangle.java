package leetcode.mst;


import java.util.LinkedList;
import java.util.Stack;

/**
 * @PackageName:leetcode.mst
 * @Date 2023/8/28 15:58
 * @Description: https://leetcode.cn/problems/word-rectangle-lcci/
 * 面试题 17.25. 单词矩阵
 * 提示
 * 困难
 * 46
 * 相关企业
 * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
 * <p>
 * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
 * 输出:
 * [
 * "this",
 * "real",
 * "hard"
 * ]
 * 示例 2:
 * <p>
 * 输入: ["aa"]
 * 输出: ["aa","aa"]
 * 说明：
 * <p>
 * words.length <= 1000
 * words[i].length <= 100
 * 数据保证单词足够随机
 */
public class H1725maxRectangle {
    private static class DTNode {
        public DTNode[] nexts = null;
        public int count = 0;

        public DTNode() {
            this.nexts = new DTNode[26];
        }
    }

    private static class DictTree {
        private DTNode root;

        public DictTree() {
            this.root = new DTNode();
        }

        public void add(String str) {
            char[] chs = str.toCharArray();
            if (chs == null || chs.length == 0) {
                return;
            }
            DTNode curNode = this.root;
            for (int i = 0; i < chs.length; i++) {
                int curIndex = chs[i] - 'a';
                if (curNode.nexts[curIndex] == null) {
                    curNode.nexts[curIndex] = new DTNode();
                }
                curNode = curNode.nexts[curIndex];
            }
            curNode.count++;
        }

        public int getCount(String str) {
            char[] chs = str.toCharArray();
            DTNode curNode = this.root;
            for (int i = 0; i < chs.length; i++) {
                int curIndex = chs[i] - 'a';
                if (curNode.nexts[curIndex] == null) {
                    return 0;
                }
                curNode = curNode.nexts[curIndex];
            }
            return curNode.count;
        }
    }

    private static class Solution {
        public String[] maxRectangle(String[] words) {
            DictTree tree = new DictTree();
            int maxLen = 0;
            for (int i = 0; i < words.length; i++) {
                maxLen = Math.max(maxLen, words[i].length());
                tree.add(words[i]);
            }
            String[] res = new String[0];
            int area = 0;
            LinkedList<String> pre = new LinkedList<>();
            for (int i = 0; i < words.length; i++) {
                int col = words[i].length();
                pre.addLast(words[i]);
                dfs(pre, tree, col, words);
                pre.pollLast();

            }
            return res;

        }

        private void dfs(LinkedList<String> pre, DictTree tree, int col, String[] words) {
            if (pre.size() > col) {
                return;
            }
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].length() == col && isValid(pre, null, tree, words[j])) {
                        dfs(pre, tree, col, words);
                    }
                }
            }
        }

        private boolean isValid(LinkedList<String> stack, Stack<Character>[] pres, DictTree tree, String word) {
            int n = word.length();

            for (int i = 0; i < n; i++) {

            }
            return false;
        }

        private int getArea(String[] res01) {
            return res01.length * res01[0].length();
        }


    }

    public static void main(String[] args) {
        String[] words = {"this", "real", "hard", "trh", "hea", "iar", "sld"};
        Solution solve = new Solution();
        String[] res = solve.maxRectangle(words);
        System.out.println(res);
    }
}
