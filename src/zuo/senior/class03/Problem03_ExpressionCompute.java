package zuo.senior.class03;

import java.util.LinkedList;
import java.util.concurrent.TransferQueue;


public class Problem03_ExpressionCompute {
    private static int[] value(char[] chs, int i) {
        LinkedList<String> que = new LinkedList<>();
        int num = 0;
        while (i < chs.length && chs[i] != ')') {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = 10 * num + chs[i] - '0';
            } else if (chs[i] == '(') {
                int[] subValue = value(chs, i + 1);
                num = subValue[0];
                i = subValue[1];
            } else {
                addNum(que, num);
                que.addLast(String.valueOf(chs[i++]));
                num = 0;
            }
        }
        return new int[]{getNum(que), i + 1};
    }

    private static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals('+')) {
                add = true;
            } else if (cur.equals('-')) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    private static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            String cur = que.pollLast();
            if (cur.equals('*')) {
                que.addLast(String.valueOf(Integer.valueOf(que.pollLast()) * num));
            } else if (cur.equals('/')) {
                que.addLast(String.valueOf(Integer.valueOf(que.pollLast()) / num));
            } else {
                que.addLast(String.valueOf(num));
            }
        }
    }
}
