package a700;

public class M799champagneTower {
    protected static class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[][]dp=new double[101][101];
            double remain=0;
            dp[0][0]=poured;
            for (int i = 0; i <=query_row; i++) {
                for (int j = 0; j <= i; j++) {
                    if(dp[i][j]>1){
                        remain=dp[i][j]-1;
                        dp[i][j]=1;
                        dp[i+1][j]+=remain/2;
                        dp[i+1][j+1]+=remain/2;
                    }
                }
            }
            return dp[query_row][query_glass];
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int poured = 100000009, query_row = 33, query_glass = 17;
        int poured = 1, query_row = 1, query_glass = 1;
        double result = solution.champagneTower(poured, query_row, query_glass);
        System.out.println(result);
    }
}
