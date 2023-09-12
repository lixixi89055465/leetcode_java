package luogu.P20;

/**
 * @PackageName:luogu.P20
 * @Date 2023/9/12 9:40
 * @Description:
 */
public class testGCD {
    int exgcd(int a,int b,int x,int y){
        if (b == 0) {
            x=1;y=0;
            return a;
        }
        int r=exgcd(a,b%a,x,y);
        int temp=y;
        y=x-a/b*y;
        x=temp ;
        return r;
    }
}
