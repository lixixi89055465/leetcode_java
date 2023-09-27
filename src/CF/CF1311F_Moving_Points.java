package CF;

import java.util.Scanner;

/**
 * @PackageName:CF
 * @Date 2023/9/26 11:30
 * @Description: https://codeforces.com/problemset/problem/1311/F
 */
public class CF1311F_Moving_Points {

    private static class TreeArr{
        public int[]tree;
        public int n;
        public TreeArr(int n) {
            this.tree = new int[n];
            this.n=n;
        }
        public int query(int n){
            int sum=0;
            for (int i = n; i >=0; i-=lowbit(i)) {
                sum+=this.tree[i];
            }
            return sum;
        }
        public void update(int i,int x){
            for (int j = i; j < n; j+=lowbit(j)) {
                this.tree[j]+=x;
            }
        }

        private int lowbit(int i) {
            return i&-i;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int []xArr=new int[n];
        for (int i = 0; i < n; i++) {
            xArr[i]=sc.nextInt();
        }
        int []vArr=new int[n];
        for (int i = 0; i < n; i++) {
            vArr[i]=sc.nextInt();
        }
        int []L=new int[n];

        for (int i = 0; i < n; i++) {
            L[i]=lowBound(i,xArr);
        }
        TreeArr countTree= new TreeArr(n);
        TreeArr distanceTree= new TreeArr(n*xArr[n-1]);
        int ans=0;
        for (int i = 0; i < n; i++) {
            int query = countTree.query(i);
            int disSum=distanceTree.query(xArr[i]);
            ans+=(query+1)*xArr[i]- disSum;
            countTree.update(i,1);
            distanceTree.update(i,xArr[i]);
        }
        System.out.println(ans);

    }

    private static int lowBound(int i, int[] xArr) {
        return 0;
    }
}
