package ZJ.suppplement;

/**
 * @author lixiang
 * data 2023/8/3
 * 首先引用一些考到本题的面经原文描述
 *
 * 0-12共13个数构成一个环，从0出发，每次走1步，走n步回到0共有多少种走法（2020.09 字节跳动-广告-后端）[1]
 * 0-8组成一个圆环，从0出发，每次可以逆时针和顺时针走，走n步能回到0有多少种情况（2020.09 字节跳动-people-后端）[2]
 * 0~9的环，从0出发，N步后能否走回0。（2020.07 字节跳动-电商-后端）[3]
 * 圆环回原点问题 (2020.08 字节跳动-飞书-后端)[4]
 * 题目描述
 *
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 *
 * 输入: 2
 * 输出: 2
 * 解释：有2种方案。分别是0->1->0和0->9->0
 * 圆环回原点问题
 */
public class Solution01 {
    public int process(int circleNum, int n){
        int[][]dp=new int[n+1][circleNum];
        for (int i = 1; i <= (circleNum+1)/2; i++) {
            dp[i][i]=i;
            dp[i][circleNum-i]=i;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < circleNum; j++) {
                if(dp[i][j]==0) {
                    dp[i][j] = dp[i - 1][(j - 1 + circleNum) % circleNum] + dp[i - 1][(j + 1) % circleNum];
                }
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
//        int n=12,circleNum=3;
        int n=2,circleNum=2;
        Solution01 solve = new Solution01();
        int res=solve.process(circleNum,n);
        System.out.println(res);
    }

}
