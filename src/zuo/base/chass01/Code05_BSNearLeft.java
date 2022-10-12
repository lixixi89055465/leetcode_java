package zuo.base.chass01;

/**
 * 最边最小值
 */
public class Code05_BSNearLeft {
    public static int exist(int[] arr, int value) {
        int L=0;
        int R=arr.length-1;
        int index=-1;
        int mid=-1;
        while (L<R){
            mid=L+((R-L)>>2);
            if(arr[mid]>=value){
                index=mid;
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        return index;
    }
}
