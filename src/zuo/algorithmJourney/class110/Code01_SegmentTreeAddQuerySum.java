package zuo.algorithmJourney.class110;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/28 21:35
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class Code01_SegmentTreeAddQuerySum {

    public static int MAXN = 100001;
    public static long[] arr = new long[MAXN];
    public static long[] sum = new long[MAXN << 2];
    public static long[] add = new long[MAXN << 2];

    public static void up(int i) {
        sum[i] = sum[i << 1] + sum[i << 1 | 1];
    }

    //懒信息的下发
    public static void down(int i, int ln, int rn) {
        if (add[i] != 0) {
            lazy(i << 1, add[i], ln);
            lazy(i << 1 | 1, add[i], rn);
            add[i] = 0;
        }
    }

    private static void lazy(int i, long v, int n) {
        sum[i] += v * n;
        add[i] += v;
    }

    //建树
    public static void build(int l, int r, int i) {
        if (l == r) {
            sum[i] = arr[l];
        } else {
            int mid = (r - l) >> 1 + l;
            build(l, mid, i << 1);
            build(mid + 1, r, i << 1 | 1);
            sum[i] = sum[i << 1] + sum[i << 1 | 1];
        }
        add[i] = 0;
    }

    public static void add(int jobl, int jobr, int jobv, int l, int r, int i) {
        if (jobl <= l && jobr >= r) {
            lazy(i, jobv, r - l + 1);
        } else {
            int mid = (r - l) >> 1 + l;
            down(i, mid - l + 1, r - mid);
            if (jobl <= mid) {
                add(jobl, jobr, jobv, l, mid, i << 1);
            }
            if (jobr > mid) {
                add(jobl, jobr, jobv, mid + 1, r, i << 1 | 1);
            }
            up(i);
        }
    }

    //查询累加和
    public static long query(int jobl, int jobr, int l, int r, int i) {
        if (jobl <= l && jobr > r) {
            return sum[i];
        }
        int mid = (r - l) >> 1 + l;
        down(i, mid - l + 1, r - mid);
        long ans = 0;
        if (jobl <= mid) {
            ans += query(jobl, jobr, l, mid, i << 1);
        }
        if (jobr > mid) {
            ans += query(jobl, jobr, mid + 1, r, i << 1 | 1);
        }
        return ans;
    }
}
