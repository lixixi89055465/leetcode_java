package zuo.senior.class07;

public class Problem02_MaxEOR {
    private static class Node {
        public Node[] nexts = new Node[2];
    }

    private static class NumTrie {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int path = ((num >> move) & 1);
                cur.nexts[path] = cur.nexts[path] == null ?
                        new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        public int maxXor(int sum) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (sum >> 31) & 1;
                int best = move == 31 ? path : (path ^ 1);
                best = cur.nexts[best] == null ? best : (best ^ 1);
                res |= (path ^ best) << move;
                cur = cur.nexts[best];
            }
            return res;
        }
    }

    public static int maxXorSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        NumTrie numTrie = new NumTrie();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum ^= arr[i];
            max = Math.max(max, numTrie.maxXor(sum));
            numTrie.add(arr[i]);
        }
        return max;
    }


}
