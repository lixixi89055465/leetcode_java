package luogu.P20;

import java.util.Scanner;

/**
 * @PackageName:luogu.P20
 * @Date 2023/9/12 14:54
 * @Description:
 * （洛谷P2880 [USACO07JAN]平衡的阵容Balanced Lineup）
 *
 * 题目背景
 * 每天,农夫 John 的N(1 <= N <= 50,000)头牛总是按同一序列排队. 有一天, John 决定让一些牛们玩一场飞盘比赛.
 * 他准备找一群在对列中为置连续的牛来进行比赛. 但是为了避免水平悬殊,牛的身高不应该相差太大.
 * John 准备了Q (1 <= Q <= 200,000) 个可能的牛的选择和所有牛的身高 (1 <= 身高 <= 1,000,000).
 * 他想知道每一组里面最高和最低的牛的身高差别.
 * 输入格式
 * 第1行：N,Q
 * 第2到N+1行：每头牛的身高
 * 第N+2到N+Q+1行：两个整数A和B，表示从A到B的所有牛。（1<=A<=B<=N）
 * 输出格式
 * 输出每行一个数，为最大数与最小数的差
 */
public class P2880 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().trim().split(",");
        int N=Integer.parseInt(split[0]);
        int Q=Integer.parseInt(split[0]);
        int []arr=new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        int[][]quick=process(N,arr);
        int []QArr=new int[Q];
        for (int i = 0; i < Q; i++) {
            String[] split1 = sc.nextLine().trim().split(",");
            int start=Integer.parseInt(split1[0]);
            int end=Integer.parseInt(split1[1]);
            int k=0;
            while (((k+1)<<1)<=end-start+1){
               k+=1;
            }
            System.out.println(Math.max(quick[start][k],quick[end-(1<<k)][k]));
        }
    }

    private static int[][] process(int n, int[] arr) {
        int[][]f=new int[n][22];
        for (int i = 0; i < n; i++) {
            f[i][0]=arr[i];
        }
        for (int i = 1; i < 22; i++) {
            for (int j = 1; j < n; j++) {
                f[j][i]=Math.max(f[j][i-1],f[j+(1<<(i -1))][i-1]);
            }
        }
        return f;
    }
}
