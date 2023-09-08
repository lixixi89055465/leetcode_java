package TYVJ;

public class test1 {
    public static void main(String[] args) {
        int N=10;
//        int res=Floyd(N);
//        System.out.println(res);
    }
    public static int []Bellman_Ford(int n,int m){
        int[]dist=new int[n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
//                dist[edges[j].to]=Math.min(dist[edges[j].to], dist[edges[j].from]+edges[j].w)
            }
        }
        return dist;
    }

    private static int[][] Floyd(int N) {
        int [][]dist=new int[N+1][N+1];

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        System.out.println(dist);
        return dist;
    }
}
