package leetcode.top100;

/**
 * @PackageName:leetcode.top100
 * @Date 2023/9/4 13:53
 * @Description:
 */
public class Hungarian {
    public int process(boolean[][] concats, int M, int N) {
        boolean[] visit = new boolean[N];
        int[] p = new int[N];
        int ans=0;
        for (int i = 0; i < M; i++) {
            if(match(i,N,concats,visit,p)){
                ans++;
            }
        }
        return ans;

    }

    private boolean match(int i, int N, boolean[][] map, boolean[] visit, int[] p) {
        for (int j = 0; j < N; j++) {
            if(!visit[j]&&map[i][j]) {
                visit[j]=true;
                if (p[j]==0 || match(p[j], N, map, visit, p)) {
                    p[j]=i;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
