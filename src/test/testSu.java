package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:test
 * @Date 2023/9/21 13:27
 * @Description:
 */
public class testSu {
    private static  List<Integer> process02(int n){
        boolean[]isValid=new boolean[n+1];
        List<Integer> prime=new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(!isValid[i]){
                prime.add(i);
            }
            for (Integer p : prime) {
                if (p * i > n) {
                    break;
                }
                isValid[p*i]=true;
                if (i % p == 0) {
                    break;
                }
            }
        }
        prime.stream().forEach(System.out::println);
        return prime;
    }
    private static   ArrayList<Integer> process01(int n){
        boolean[]isValid=new boolean[n+1];
        for (int i = 2; i*i <=n; i++) {
            if(!isValid[i]){
                for (int j = i*i; j <= n; j += i) {
                    isValid[j]=true;
                }
            }
        }
        ArrayList<Integer> res= new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(!isValid[i]){
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(process02(10));
    }
}
