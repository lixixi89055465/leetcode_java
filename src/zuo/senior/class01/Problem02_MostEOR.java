package zuo.senior.class01;

import java.util.HashMap;

public class Problem02_MostEOR {
//    public static int mostEOR(int[] arr) {
//        int xor = 0;
//        int[] dp = new int[arr.length];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0, -1);
//        for (int i = 0; i < arr.length; i++) {
//            xor ^= arr[i];
//            if (map.containsKey(xor)) {
//                int pre = map.get(xor);
//                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
//            }
//            if (i > 0) {
//                dp[i] = Math.max(dp[i - 1], dp[i]);
//            }
//            map.put(xor, i);
//        }
//        return dp[arr.length - 1];
//    }

    public static int mostEOR(int[] arr) {
        int xor=0;
        int[]dp=new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            xor^=arr[i];
            if(map.containsKey(xor)){
                int pre=map.get(xor);
                dp[i]=pre==-1?1:(dp[pre]+1);
            }
            if(i>0){
                dp[i]=Math.max(dp[i],dp[i-1]);
            }
            map.put(xor,i);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {

    }

}
