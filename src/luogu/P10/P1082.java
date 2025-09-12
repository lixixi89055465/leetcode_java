package luogu.P10;


import java.util.Scanner;

/**
 * @PackageName:luogu.P10
 * @Date 2023/9/12 10:03
 * @Description:
 * 题目描述
 * 求关于
 *  的同余方程
 *  的最小正整数解。
 * 输入格式
 * 一行，包含两个正整数
 *  ，用一个空格隔开。
 * 输出格式
 * 一个正整数
 *  ，即最小正整数解。输入数据保证一定有解。
 */
public class P1082 {
    private static int gcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return gcd(b,b%a);
    }
    private static int x,y;
    private static int exgcd(int a,int b){
        if (b == 0) {
            x=1;y=0;
            return a;
        }
        int ans=exgcd(a,b);
        int temp=y;
        y=x-(a/b)*y;
        x=temp;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b= Integer.parseInt(sc.nextLine().trim());
        exgcd(a,b);
        x=(x%b+b)%b;
        System.out.println(x);
    }


}
