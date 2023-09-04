package leetcode.top100;

/**
 * @PackageName:leetcode.top100
 * @Date 2023/9/4 13:53
 * @Description:
 */
public class Hungarian {
    public int process(boolean[][] concats, int M, int N) {
        int cnt = 0;
        boolean[] visit = new boolean[N];
        int[] P = new int[N];
        for (int i = 0; i < M; i++) {
            if (match(i, N, concats, visit, P)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean match(int i, int N, boolean[][] map, boolean[] visit, int[] P) {
        for (int j = 0; j < i; j++) {
            if (!visit[j] && map[i][j]) {
                visit[j] = true;
                if (P[j] == 0 || match(P[j], N, map, visit, P)) {
                    P[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
