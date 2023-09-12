package luogu.P20;

import java.util.Scanner;

/**
 * @PackageName:luogu.P20
 * @Date 2023/9/11 10:37
 * @Description: https://www.luogu.com.cn/problem/P2024
 * # [NOI2001] 食物链
 * <p>
 * ## 题目描述
 * <p>
 * 动物王国中有三类动物 $A,B,C$，这三类动物的食物链构成了有趣的环形。$A$ 吃 $B$，$B$ 吃 $C$，$C$ 吃 $A$。
 * <p>
 * 现有 $N$ 个动物，以 $1 \sim N$ 编号。每个动物都是 $A,B,C$ 中的一种，但是我们并不知道它到底是哪一种。
 * <p>
 * 有人用两种说法对这 $N$ 个动物所构成的食物链关系进行描述：
 * <p>
 * - 第一种说法是 `1 X Y`，表示 $X$ 和 $Y$ 是同类。
 * - 第二种说法是`2 X Y`，表示 $X$ 吃 $Y$。
 * <p>
 * 此人对 $N$ 个动物，用上述两种说法，一句接一句地说出 $K$ 句话，这 $K$ 句话有的是真的，有的是假的。当一句话满足下列三条之一时，这句话就是假话，否则就是真话。
 * <p>
 * - 当前的话与前面的某些真的话冲突，就是假话；
 * - 当前的话中 $X$ 或 $Y$ 比 $N$ 大，就是假话；
 * - 当前的话表示 $X$ 吃 $X$，就是假话。
 * <p>
 * 你的任务是根据给定的 $N$ 和 $K$ 句话，输出假话的总数。
 * <p>
 * ## 输入格式
 * <p>
 * 第一行两个整数，$N,K$，表示有 $N$ 个动物，$K$ 句话。
 * <p>
 * 第二行开始每行一句话（按照题目要求，见样例）
 * <p>
 * ## 输出格式
 * <p>
 * 一行，一个整数，表示假话的总数。
 * <p>
 * ## 样例 #1
 * <p>
 * ### 样例输入 #1
 * <p>
 * ```
 * 100 7
 * 1 101 1
 * 2 1 2
 * 2 2 3
 * 2 3 3
 * 1 1 3
 * 2 3 1
 * 1 5 5
 * ```
 * <p>
 * ### 样例输出 #1
 * <p>
 * ```
 * 3
 * ```
 * <p>
 * ## 提示
 * <p>
 * 对于全部数据，$1\le N\le 5 \times 10^4$，$1\le K \le 10^5$。
 */
public class P2024 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = Integer.parseInt(sc.nextLine().trim());

        int[] fa = new int[N * 3];
        int[] rank = new int[N * 3];
        for (int i = 0; i < 3 * N; i++) {
            fa[i] = i;
        }
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int type = sc.nextInt();
            int X = sc.nextInt();
            int Y = Integer.parseInt(sc.nextLine().trim());
            if (X > N || Y > N) {
                ans+=1;
                continue;
            }
            if (type == 1) {
                if (query(X, Y + N, fa) || query(X + N, Y + 2 * N, fa) || query(X + 2 * N, Y, fa)) {
                    ans += 1;
                } else {
                    merge(X, Y, fa, rank);
                    merge(X + N, Y + N, fa, rank);
                    merge(X + 2 * N, Y + 2 * N, fa, rank);
                }
            } else if (type == 2) {
                if (query(X, X, fa) || query(X + N, Y + N, fa) || query(X + 2 * N, Y + 2 * N, fa)) {
                    ans = +1;
                } else {
                    merge(X, Y + N, fa, rank);
                    merge(X + N, Y + 2 * N, fa, rank);
                    merge(X + 2 * N, Y, fa, rank);
                }
            } else {
                ans+=1;
            }
        }

    }

    private static void merge(int x, int y, int[] fa, int[] rank) {
        int xindex = find(x, fa);
        int yindex = find(y, fa);
        if (rank[xindex] >= rank[yindex]) {
            fa[yindex] = xindex;
        } else {
            fa[xindex] = yindex;
        }
        if (xindex == yindex) {
            rank[xindex] += 1;
        }
    }


    private static boolean query(int x, int y, int[] fa) {
        return find(x, fa) == find(y, fa);
    }

    private static int find(int x, int[] fa) {
        return fa[x] == x ? x : find(fa[x], fa);
    }
}
