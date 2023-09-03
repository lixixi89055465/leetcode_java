package luogu.P19;

import java.util.TreeMap;

/**
 * （洛谷P1908） 逆序对
 * <p>
 * 题目描述
 * 猫猫TOM和小老鼠JERRY最近又较量上了，但是毕竟都是成年人，他们已经不喜欢再玩那种你追我赶的游戏，现在他们喜欢玩统计。最近，TOM老猫查阅到一个人类称之为“逆序对”的东西，这东西是这样定义的：对于给定的一段正整数序列，逆序对就是序列中ai>aj且i<j的有序对。知道这概念后，他们就比赛谁先算出给定的一段正整数序列中逆序对的数目。
 * 输入格式
 * 第一行，一个数n，表示序列中有n个数。
 * 第二行n个数，表示给定的序列。序列中每个数字不超过10^9
 * 输出格式
 * 给定序列中逆序对的数目。
 */
public class P1908 {
    private static class BinaryTree {
        public int[] tree;
        public int maxLen = 0;

        public BinaryTree(int maxLen) {
            this.maxLen = maxLen;
            this.tree = new int[maxLen];
        }

        public void update(int i, int x) {
            for (int j = i; j <= this.maxLen; j += lowBit(j)) {
                this.tree[j - 1] += x;
            }
        }

        private int lowBit(int i) {
            return i & (-i);
        }

        public int query(int end) {
            int ans = 0;
            for (int j = end; j > 0; j -= lowBit(j)) {
                ans += this.tree[j - 1];
            }
            return ans;
        }
    }

    public static int process(int[] nums) {
        BinaryTree binaryTree = new BinaryTree(nums.length);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += binaryTree.query(nums[i]);
            binaryTree.update(nums[i], 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 2, 4};
        System.out.println(process(nums));


    }
}
