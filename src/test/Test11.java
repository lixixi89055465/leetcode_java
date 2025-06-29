package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
//        [1,4,5,2,2]
//        7
//        String s = "[5,2]";
//        int count = 7;
        String s = "[-1,2,4,9, 6]";
        int count = 8;
        s=s.replaceAll(" ","");
        s = s.substring(1, s.length() - 1);
        String[] split = s.split(",");
        HashMap<Integer, Integer> cache1 = new HashMap<Integer, Integer>();
//        HashMap<Integer, Integer> cache2 = new HashMap<Integer, Integer>();
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        for (int i = split.length - 1; i >= 0; i--) {
            int a = Integer.parseInt(split[i]);
            arr[i] = a;
//            if(cache1.containsKey(a)){
//                cache2.put(a,cache1.get(a));
//            }
            cache1.put(a, i);
        }
        int res = Integer.MAX_VALUE;
        int[] result= new int[2];
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (cache1.containsKey(a) && cache1.containsKey(count - a)) {
//                res=Math.min(res,cache1.get(a)+cache1.get(count-a));
                Integer sum = cache1.get(a) + cache1.get(count - a);
                if (sum < res) {
                    res=sum;
                    result[0] = a;
                    result[1] = count - a;
                }
            }
        }
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}
