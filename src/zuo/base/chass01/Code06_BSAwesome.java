package zuo.base.chass01;

/**
 * 是用二分法获取局部最小值
 */
public class Code06_BSAwesome {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int L = 0;
        int R = arr.length - 1;
        int mid=-1;
        while (L < R) {
            mid=L+((R-L)>>2);
            if(arr[mid]<arr[mid+1] &&arr[mid-1]<arr[mid]){
                return mid;
            }
            if(arr[mid]>arr[mid-1]){
                 R=mid-1;
            }else if(arr[mid]>arr[mid+1]){
                L=mid+1;
            }else{
                return mid;
            }
        }
        return L;
    }
}
