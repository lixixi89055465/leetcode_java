package zuo.intermediate.class06;

public class Problem04_PreAndInArray {
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
}
