package leetcode.a900;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class M907sumSubarrayMins {

    public static int sumSubarrayMins(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int []left=new int[arr.length];
        int []right=new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            left[i]=i-(st.isEmpty()?-1:st.peek());
            st.add(i);
        }
        st.clear();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!st.isEmpty()&&arr[st.peek()]>arr[i]){
                st.pop();
            }
            right[i]=(st.isEmpty()?arr.length:st.peek())-i;
            st.add(i);
        }
        Long ans= Long.valueOf(0);
        for (int i = 0; i <arr.length ; i++) {
            ans+=(long)(arr[i]*left[i]*right[i]);
            ans%=1000000007;
        }
        return ans.intValue();
    }
    public static int[]getRandArr(int len){
        int[]arr=new int[len];
        for (int i = 0; i < len; i++) {
           arr[i]=(int)(Math.random()*200000);
        }
        return arr;
    }

    public static int sumSubarrayMins1(int[] arr) {
        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<Integer>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peek()]) {
                monoStack.pop();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]) {
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek()) - i;
            monoStack.push(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }
    public static void main(String[] args) {
//        int[] arr = {3, 1, 2, 4};
//        int[]arr = {11,81,94,43,3};
        for (int k = 0; k < 2000; k++) {
            int[]arr=getRandArr(2000);
            int r1 = sumSubarrayMins(arr);
            int r2 = sumSubarrayMins1(arr);
            if(r1!=r2){
                for (int i : arr) {
                    System.out.print(i+",");
                }
                System.out.println();
            }
        }
    }
}
