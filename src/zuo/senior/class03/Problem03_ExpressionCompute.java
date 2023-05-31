package zuo.senior.class03;

import java.util.LinkedList;


public class Problem03_ExpressionCompute {
    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<>();
        int num = 0;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {
                num = num * 10 + str[i] - '0';
                i++;
            } else if (str[i] == '(') {
                int[] subV = value(str, i + 1);
                num = subV[0];
                i = subV[1] + 1;
            } else {
                addNum(que, num);
                que.addLast(String.valueOf(str[i++]));
                num = 0;
            }
        }
        return new int[]{getNum(que), i + 1};
    }

    private static int getNum(LinkedList<String> que) {
        int res = 0;
        int num = 0;
        while (!que.isEmpty()) {
            String cur = que.pollFirst();
            boolean add = true;
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                cur += add ? num : -num;
            }
        }
        return res;
    }

    private static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static void main(String[] args) {

    }
}
