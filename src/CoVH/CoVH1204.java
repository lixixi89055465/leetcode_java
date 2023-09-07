package CoVH;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName:CoVH
 * @Date 2023/9/6 17:16
 * @Description: https://vijos.org/p/1204
 * (vijos1204） CoVH之柯南开锁
 *
 * 面对OIBH组织的嚣张气焰, 柯南决定深入牛棚, 一探虚实.
 * 他经过深思熟虑, 决定从OIBH组织大门进入...........
 * OIBH组织的大门有一个很神奇的锁.
 * 锁是由M*N个格子组成, 其中某些格子凸起(灰色的格子). 每一次操作可以把某一行或某一列的格子给按下去.
 *
 * 如果柯南能在组织限定的次数内将所有格子都按下去, 那么他就能够进入总部. 但是OIBH组织不是吃素的, 他们的限定次数恰是最少次数.
 * 请您帮助柯南计算出开给定的锁所需的最少次数.
 *
 * 读入/Input：
 *
 * 第一行 两个不超过100的正整数N, M表示矩阵的长和宽
 * 以下N行 每行M个数 非0即1 1为凸起方格
 *
 *
 * 输出/Output：
 *
 * 一个整数 所需最少次数
 * 如果我们把样例的矩阵，转化为二分图的形式，是这样的：
 */
public class CoVH1204 {
    public static int process(char[][] map) {
        int N=map.length;
        int M=map[0].length;
        int []P=new int[M];
        int ans=0;
        boolean[]visit=new boolean[M];
        Arrays.fill(visit,false);
        for (int i = 0; i < N; i++) {
            if(match(i,visit,P,map)){
                ans+=1;
            }
        }
        return ans;
    }

    private static boolean match(int i, boolean[] visit, int[] P, char[][] map) {
        int M=visit.length;
        for (int j = 0; j < M; j++) {
            if(!visit[j]&&map[i][j]=='1'){
                visit[j]=true;
                if(P[j]==0||match(P[j]-1,visit,P,map)){
                    P[j]=i+1;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=Integer.parseInt(sc.nextLine().trim());
        if (N == 0 || M == 0) {
            System.out.println(0);
            return;
        }
        char [][]map=new char[N][M];
        for (int i = 0; i <M ; i++) {
            map[i]=sc.nextLine().toCharArray();
        }
        System.out.println(process(map));
    }
}
