package zuo.base.class07;

public class Code01_TrieTree {
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        public TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            if (null == word || word.length() == 0) {
                return;
            }
            TrieNode curTree = this.root;
            int index = 0;
            for (char c : word.toCharArray()) {
                index = c - 'a';
                if (curTree.nexts[index] == null) {
                    curTree.nexts[index] = new TrieNode();
                }
                curTree = curTree.nexts[c - 'a'];
                curTree.pass++;
            }
            curTree.end++;
        }

        public void delete(String word) {
            if (null == word || word.length() == 0) {
                return;
            }
            TrieNode curNode = this.root;
            int index = 0;
            for (char c : word.toCharArray()) {
                if (curNode.nexts[c - 'a'] == null) {
                    break;
                }
                index++;
                curNode = curNode.nexts[c - 'a'];
            }
            if (index < word.length()) {
                return;
            }
            TrieNode lastNode = null;
            char lastC = 0;
            for (char c : word.toCharArray()) {
                lastNode = curNode;
                lastC = c;
                curNode = curNode.nexts[c - 'a'];
                curNode.pass--;
            }
            curNode.end--;
            if (curNode.end == 0) {
                lastNode.nexts[lastC - 'a'] = null;
            }
        }

        public int search(String word) {
            if (null == word) {
                return 0;
            }
            TrieNode curNode = this.root;
            for (char c : word.toCharArray()) {
                if (curNode.nexts[c - 'a'] == null) {
                    return -1;
                }
                if (curNode.pass == 0) {
                    return -1;
                }
                curNode = curNode.nexts[c - 'a'];
            }
            return curNode.end;

        }

        public int prefixNumber(String prefix) {
            TrieNode curNode = this.root;
            for (char c : prefix.toCharArray()) {
                if (curNode.nexts[c - 'a'] == null) {
                    return 0;
                }
                curNode = curNode.nexts[c - 'a'];
                if (curNode.pass == 0) {
                    return 0;
                }
            }
            return curNode.pass;
        }
    }

}
