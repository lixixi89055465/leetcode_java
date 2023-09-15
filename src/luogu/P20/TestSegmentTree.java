package luogu.P20;

/**
 * @PackageName:luogu.P20
 * @Date 2023/9/12 17:44
 * @Description:
 */
public class TestSegmentTree {
    public static void main(String[] args) {

    }

    public void buildTree(int[] tree, int s, int e, int p, int[] A) {
        if (s == e) {
            tree[p] = A[s];
            return;
        }
        int m = s + (e - s) >> 2;
        buildTree(tree, s, m, p * 2, A);
        buildTree(tree, m, e, p * 2 + 1, A);
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    public int getSum(int[] tree, int L, int R, int s, int e, int p) {
        if (L <= s && e <= e) {
            return tree[p];
        }
        int m = s + (e - s) >> 2;
        int sum = 0;
        if (L <= m) {
            sum += getSum(tree, L, R, s, m, p * 2);
        }
        if (R > m) {
            sum += getSum(tree, L, R, m + 1, e, p * 2 + 1);
        }
        return sum;
    }

    int getSum01(int[] tree, int L, int R, int S, int T, int p, int[] B) {
        return 0;
    }

    public void update(int[] tree, int L, int R, int c, int S, int T, int P, int[] B) {
        if (L <= S && R <= T) {
            tree[P] += (R - S + 1) * c;
            B[P] = c;

        }
    }

    public void update01(int[] tree, int L, int R, int c, int S, int T, int p, int[] B) {
        if (L <= S && T <= R) {
            tree[p] += (T - S + 1) * c;
            B[p] += c;
            return;
        }
        int m = S + (T - S) >> 1;
        if (B[p] > 0 && S != T) {
            B[p * 2] += (m - S + 1) * B[p];
            B[p * 2 + 1] += (T - m) * B[p];
            B[p * 2] += B[p];
            B[p * 2 + 1] += B[p];
            B[p] = 0;
        }
        if (L <= m) {
            update(tree, L, R, c, S, m, p, B);
        }
        if (m < R) {
            update(tree, L, R, c, m + 1, T, p, B);
        }
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }
}
