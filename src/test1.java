import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        int q = Integer.parseInt(sc.next());
        int[][] arr = new int[n][2];
        int[][] par = new int[m][2];
        int[][] ju = new int[n+1][n+1];
        int i = 0;
        while (i < m) {
            int i1 = Integer.parseInt(sc.next());
            int i2 = Integer.parseInt(sc.next());
            arr[i][0] = i1;
            arr[i][1] = i2;
            ju[i1][i2] = 1;
            ju[i2][i1] = 1;
            i++;
        }
        i = 0;
        int[] a = null;
        int j = 0;

        while (i < q) {
            int i1 = Integer.parseInt(sc.next());
            int i2 = Integer.parseInt(sc.next());
            par[i][0] = i1;
            par[i][1] = i2;
            for (j = 1; j <= n; j++) {
                int k = ju[i1][j];
                ju[i1][j] = ju[i2][j];
                ju[i2][j] = k;
            }
            for (j = 1; j <= n; j++) {
                int k = ju[j][i1];
                ju[j][i1] = ju[j][i2];
                ju[j][i2] = k;
            }
            i++;
        }
        for(i=1;i<=m;i++){
            int s=0;
            for(j=1;j<=m;j++){
               s+=ju[i][j];
            }
            System.out.print(s+" ");
        }

    }
}
