package zuo.publicclass2020.class101;

public class test1 {
    public static int zuo(int i, int f, int s, int t, int n, int m) {
        if (i == n) {
            return t != 0 ? 1 : 0;
        }
        //i < n
        // 1 ~ m
        int ans = 0;
        for (int num = 1; num <= m; num++) {
            if (f == 0 || f >= num) {
                ans += zuo(i + 1, num, s, t, n, m);
            } else if (s == 0 || s >= num) {
                ans += zuo(i + 1, f, num, t, n, m);
            } else if (t == 0 || t >= num) {
                ans += zuo(i + 1, f, s, num, n, m);
            }else{ //都没拦住 ! 最长递增子序列的长度将到达 4 ， 不合法
//                ans+=0;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
