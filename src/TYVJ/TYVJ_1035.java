package TYVJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @PackageName:TYVJ
 * @Date 2023/9/7 10:55
 * @Description: http://www.joyoi.cn/problem/tyvj-1035
 * 题目描述
 * 给出一张 n (n<=100 )的国际象棋棋盘，其中被删除了一些点，问可以使用多少1∗2 的多米诺骨牌进行掩盖。
 * <p>
 * 输入
 * 第一行为n ，m （表示有m 个删除的格子）
 * 第二行到m+1 行为x,y ，分别表示删除格子所在的位置 x 为第x 行 y 为第y 列 输出 一个数，即最大覆盖格数
 */
public class TYVJ_1035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = Integer.parseInt(sc.nextLine().trim());
        int[][] MArr = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] split = sc.nextLine().trim().split(" ");
            MArr[i][0] = Integer.parseInt(split[0]);
            MArr[i][1] = Integer.parseInt(split[1]);
        }
        int res = process(N, M, MArr);
        System.out.println(res);

    }

    private static int process(int N, int M, int[][] mArr) {
        HashSet<Integer> white = new HashSet<>();
        HashSet<Integer> black = new HashSet<>();
        HashSet<Integer> damage = new HashSet<>();
        for (int[] ints : mArr) {
            damage.add(getIndex(ints[0], ints[1], N));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (damage.contains(getIndex(i, j, N))) {
                    continue;
                }
                int tmp = getIndex(i, j, N);
                if (((i + j) & 1) == 0) {
                    white.add(tmp);
                } else {
                    black.add(tmp);
                }
            }
        }
        int[] P = new int[N * N];
        boolean[] visit = new boolean[N * N];
        int ans = 0;
        for (Integer w : white) {
            Arrays.fill(visit, false);
            if (match(w, P, visit, white, black, N, damage)) {
                ans += 1;
            }
        }
        return ans;
    }

    private static boolean match(int w, int[] P, boolean[] visit, HashSet<Integer> white, HashSet<Integer> black, int N, HashSet<Integer> damage) {
        if (damage.contains(w)) {
            return false;
        }
        ArrayList<Integer> tmpList = new ArrayList<>(4);
        int row=w/N,col=w%N;
        if(row>0){
            tmpList.add(w-N);
        }
        if (row +1< N) {
            tmpList.add(w+N);
        }
        if (col > 0) {
            tmpList.add(w-1);
        }
        if (col + 1 < N) {
            tmpList.add(w+1);
        }
        for (Integer integer : tmpList) {
            if(!visit[integer]&&!damage.contains(integer)){
                visit[integer]=true;
                if(P[integer]==0||match(P[integer],P,visit,white,black,N,damage)){
                    P[integer]=w;
                    return true;
                }
            }
        }
        return false;
    }



    private static Integer getIndex(int row, int col, int n) {
        return row * n + col;
    }
}
