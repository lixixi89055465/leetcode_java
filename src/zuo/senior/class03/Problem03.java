package zuo.senior.class03;

import java.util.LinkedList;


public class Problem03 {
    private static int[] value(char[] chs, int i) {
        LinkedList<String> que = new LinkedList<>();
        int num = 0;
        while (i < chs.length && chs[i] != ')') {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = num * 10 + chs[i] - '0';
            } else if (chs[i] == '(') {
                int[] subValue = value(chs, i + 1);
                num = subValue[0];
                i = subValue[1] + 1;
            } else {
                addNum(que, num);
                que.addLast(String.valueOf(chs[i]));

            }
        }
//        return new int[]{getNum()};
        return null;
    }

    private static void addNum(LinkedList<String> que, int num) {

    }
}
