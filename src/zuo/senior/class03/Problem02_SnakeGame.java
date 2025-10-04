package zuo.senior.class03;

public class Problem02_SnakeGame {
    private static class Info{
        public int no;
        public int yes;

        public Info(int no, int yes) {
            this.no = no;
            this.yes = yes;
        }
    }
    public static int snake(int[][]matrix){
        int ans=Integer.MAX_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                process(matrix,row,col);
            }
        }
    }
    public static int[]process(int[][]m,int i,int j) {
        if (j == 0) {
            return new int[]{m[i][j], -m[i][j]};
        }
        int[] preAns = process(m, i, j - 1);
        int preUnuse = preAns[0];
        int preUse = preAns[1];
        if (i - 1 >= 0) {
            preAns = process(m, i - 1, j - 1);
            preUnuse = Math.max(preUnuse, preAns[0]);
            preUse = Math.max(preUse, preAns[1]);
        }
        if (i + 1 < m.length) {
            preAns = process(m, i + 1, j - 1);
            preUnuse = Math.max(preUnuse, preAns[0]);
            preUse = Math.max(preUse, preAns[1]);
        }
        return new int[]{preUnuse, preUse};
    }
}
