package zuo.base.class07;

public class Code03_CardInLine {

    public static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(
                arr[i] + s(arr, i + 1, j),
                arr[j] + s(arr, i, j - 1)
        );
    }

    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(
                f(arr, i + 1, j),
                f(arr, i, j - 1)
        );
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }
    public static int dp(int []arr){
        if(arr==null|| arr.length==0){
            return 0;
        }
        int [][]f=new int[arr.length][arr.length];
        int [][]s=new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            f[i][i]=arr[i];
        }
        int row=0;
        int col=1;
        while (col<arr.length) {
            int i = row;
            int j = col;
            while (i < arr.length && j < arr.length) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
                i++;
                j++;
            }
            col++;
        }
        return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 1};
        System.out.println();

    }
}
