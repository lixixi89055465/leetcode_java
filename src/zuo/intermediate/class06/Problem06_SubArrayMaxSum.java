package zuo.intermediate.class06;

public class Problem06_SubArrayMaxSum {
    public static int maxSum(int []arr){
        if(arr==null|| arr.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int cur=0;
        for (int i = 0; i !=arr.length; i++) {
            cur+=arr[i];
            max=Math.max(cur,max);
            cur=cur<0?0:cur;
        }
        return max;
    }
    public static int maxSum1(int []arr){
        int[]dp=new int[arr.length];
        dp[0]=arr[0]>0?arr[0]:0;
        int ans=dp[0];
        for (int i = 1; i < arr.length; i++) {
            if(dp[i-1]<0){
                dp[i]=arr[i];
            }else{
                dp[i]=dp[i-1]+arr[i];
            }
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(arr));
        System.out.println(maxSum1(arr));
    }
}
