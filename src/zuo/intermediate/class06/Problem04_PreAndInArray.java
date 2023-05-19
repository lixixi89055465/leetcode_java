package zuo.intermediate.class06;

import java.util.HashMap;

public class Problem04_PreAndInArray {
    public static int[] getPostArray(int[] pre, int[] in) {
        if (pre == null) {
            return null;
        }
        int N = pre.length;
        int[] pos = new int[N];
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        set(pre, in, pos, 0, N - 1, 0, N - 1, 0, N - 1);
        return pos;
    }

    public static void set(int[] pre, int[] in, int[] pos,
                           int prei, int prej,
                           int ini, int inj,
                           int posi, int posj) {
        if (prei > prej) {
            return;
        }
        if (prei == prej) {
            pos[posi] = pre[prei];
            return;
        }
        pos[posj] = pre[prei];
        int find = ini;
        for (; find <= inj; find++) {
            if (in[find] == pre[prei]) {
                break;
            }
        }
        //in ini...find-1 find+1...inj
        set(pre, in, pos,
                prei + 1, prei + (find - ini),
                ini, find - 1,
                posi, posi + (find - ini));
        set(pre, in, pos,
                prei + (find - ini) + 1, prej,
                find + 1, inj,
                posi + (find - ini) + 1, posj
        );

    }

    public static void main(String[] args) {
        System.out.println("aaaaaaaaaa");
    }
}
