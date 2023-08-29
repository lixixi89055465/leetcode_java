package leetcode.mst;


import java.util.*;

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

    private static class Solution {
        private class DTNode {
            public DTNode[] nexts = null;
            public boolean isEnd = false;

            public DTNode() {
                this.nexts = new DTNode[26];
            }
        }

        private class DictTree {
            private DTNode root;
            private int maxArea = 0;

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
                curNode.isEnd = true;
            }

            public boolean isContain(String str) {
                char[] chs = str.toCharArray();
                DTNode curNode = this.root;
                for (int i = 0; i < chs.length; i++) {
                    int curIndex = chs[i] - 'a';
                    if (curNode.nexts[curIndex] == null) {
                        return false;
                    }
                    curNode = curNode.nexts[curIndex];
                }
                return curNode.isEnd;
            }
        }

        public String[] maxRectangle(String[] words) {
            DictTree tree = new DictTree();
            Map<Integer, List<Integer>> wordCount = new HashMap<>();
            int maxCol = 0;
            Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
            for (int i = 0; i < words.length; i++) {
                List<Integer> curList = wordCount.getOrDefault(words[i].length(), new ArrayList());
                curList.add(i);
                wordCount.put(words[i].length(), curList);
                tree.add(words[i]);
                maxCol = Math.max(maxCol, words[i].length());
            }
            Stack<String> stack = new Stack<>();
            List<String> res = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                int col = words[i].length();
                if (col * col <= tree.maxArea) {
                    break;
                }
                DTNode[] curNodes = new DTNode[col];
                for (int j = 0; j < col; j++) {
                    curNodes[j] = tree.root;
                }
                dfs(tree, words, curNodes, wordCount, col, stack, res, words[i], 1);
            }
            String[] endRes = new String[res.size()];
            res.toArray(endRes);
            return endRes;
        }

        private void dfs(DictTree tree, String[] words, DTNode[] curNodes, Map<Integer, List<Integer>> wordCount, int col, Stack<String> stack, List<String> res, String word, int index) {
            if (index > col) {
                return;
            }
            boolean flag = true;
            for (int j = 0; j < col; j++) {
                if (curNodes[j].nexts[word.charAt(j) - 'a'] == null) {
                    return;
                }
                if (!curNodes[j].nexts[word.charAt(j) - 'a'].isEnd) {
                    flag = false;
                }
            }
            stack.add(word);
            DTNode[] nextNodes = new DTNode[col];
            for (int i = 0; i < col; i++) {
                nextNodes[i] = curNodes[i].nexts[word.charAt(i) - 'a'];
            }
            if (flag) {
                int curArea = index * col;
                if (curArea > tree.maxArea) {
                    tree.maxArea = curArea;
                    res.clear();
                    for (int i = 0; i < stack.size(); i++) {
                        res.add(stack.get(i));
                    }
                }
            }
            List<Integer> curWord = wordCount.get(col);
            for (Integer curIndex : curWord) {
                dfs(tree, words, nextNodes, wordCount, col, stack, res, words[curIndex], index + 1);
            }
            stack.pop();
        }

    }

    public static void main(String[] args) {
//        String[] words = {"this", "real", "hard", "trh", "hea", "iar", "sld"};
//        String[] words = {"aa"};
//        String[] words = {"qn", "zh", "bu", "im", "pc", "iz", "mh", "v", "c", "sn"};//["im","zh"]
//        String[] words = {};
        String[] words = {"lcauj", "mdlby", "myulp", "yvkqn", "usajk", "rpj", "bojvf", "ukmkb", "afqbhs", "j", "ebe", "yacov", "wsaep", "zdk", "wziqrdd", "pcjfn", "nlrehaq", "dasrc", "lruvq", "dvca"};
        Solution solve = new Solution();
        String[] res = solve.maxRectangle(words);
        System.out.println(res);
    }
}
