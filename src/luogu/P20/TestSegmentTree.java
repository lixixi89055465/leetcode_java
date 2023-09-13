package luogu.P20;

/**
 * @PackageName:luogu.P20
 * @Date 2023/9/12 17:44
 * @Description:
 */
public class TestSegmentTree {
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
        int m=s+(e-s)>>2;
        int sum=0;
        if (L <= m) {
            sum+=getSum(tree,L,R,s,m,p*2);
        }
        if (R > m) {
            sum+=getSum(tree,L,R,m+1,e,p*2+1);
        }
        return sum;
    }


    public static void main(String[] args) {

    }
}
