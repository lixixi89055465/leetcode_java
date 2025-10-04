package zuo.senior.class03;

import javax.sound.midi.Track;
import java.security.cert.TrustAnchor;
import java.util.LinkedList;


public class Problem03 {
    private static int[] value(char[] chs, int i) {
        LinkedList<String> que = new LinkedList<>();
        int num = 0;
        while (i < chs.length && chs[i] != ')') {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = num * 10 + chs[i] - '0';
            } else if (chs[i] == '(') {
                value(chs, i + 1);
            } else {
                addNum(que, num);
                que.addLast(String.valueOf(chs[i++]));
                num = 0;
            }
        }
        return new int[]{getNum(que), i + 1};
    }
    private static void addNum(LinkedList<String>que,int num){
        if (!que.isEmpty()) {
            String cur = que.pollFirst();
            if(cur.equals("*")){
                que.addLast(String.valueOf(Integer.valueOf(que.pollLast())*num));
            }else if(cur.equals("/")){
                que.addLast(String.valueOf(Integer.valueOf(que.pollLast())/num));
            }else{
                que.addLast(String.valueOf(num));
            }
        }

    }

    private static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if(cur.equals("+")){
                add=true;
            }else if(cur.equals("-")){
                add=false;
            }else{
                num=Integer.valueOf(cur);
                res+=add?num:(-num);
            }
        }
        return res;
    }
}