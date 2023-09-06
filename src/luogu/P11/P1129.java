package luogu.P11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @PackageName:luogu.P11
 * @Date 2023/9/6 13:46
 * @Description:https://zhuanlan.zhihu.com/p/96229700#:~:text=%EF%BC%88%E6%B4%9B%E8%B0%B7P1129%EF%BC%89%20%5BZJOI2007%5D%E7%9F%A9%E9%98%B5%E6%B8%B8%E6%88%8F （洛谷P1129） [ZJOI2007]矩阵游戏
 * 题目描述
 * 小Q是一个非常聪明的孩子，除了国际象棋，他还很喜欢玩一个电脑益智游戏――矩阵游戏。矩阵游戏在一个
 * 黑白方阵进行（如同国际象棋一般，只是颜色是随意的）。每次可以对该矩阵进行两种操作：
 * 行交换操作：选择矩阵的任意两行，交换这两行（即交换对应格子的颜色）
 * 列交换操作：选择矩阵的任意两列，交换这两列（即交换对应格子的颜色）
 * 游戏的目标，即通过若干次操作，使得方阵的主对角线(左上角到右下角的连线)上的格子均为黑色。
 * 对于某些关卡，小Q百思不得其解，以致他开始怀疑这些关卡是不是根本就是无解的！于是小Q决定写一个程序来判断这些关卡是否有解。
 * 输入格式
 * 第一行包含一个整数T，表示数据的组数。
 * 接下来包含T组数据，每组数据第一行为一个整数N，表示方阵的大小；接下来N行为一个
 * 的01矩阵（0表示白色，1表示黑色）。
 * 输出格式
 * 包含T行。对于每一组数据，如果该关卡有解，输出一行Yes；否则输出一行No。
 */
public class P1129 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] mp = new int[N][N];
            for (int j = 0; j < N; j++) {
                String[] s = sc.nextLine().split(" ");
                for (int k = 0; k < s.length; k++) {
                    mp[j][k] = Integer.parseInt(s[k]);
                }
            }
            res.add(process(mp, N) ? "Yes" : "No");
        }
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static boolean process(int[][] mp, int N) {
        int[] P = new int[N];
        int res = 0;
        boolean[] visits = new boolean[N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visits,false);
            if (match(i, N, mp, P, visits)) {
                res += 1;
            }
        }
        return res == N;
    }

    private static boolean match(int i, int N, int[][] mp, int[] P, boolean[] visits) {
        for (int j = 0; j < N; j++) {
            if (!visits[j] && mp[i][j] == 1) {
                visits[j] = true;
                if (P[j] == 0 || match(P[j] - 1, N, mp, P, visits)) {
                    P[j] = i + 1;
                    return true;
                }
            }
        }
        return false;
    }
}
