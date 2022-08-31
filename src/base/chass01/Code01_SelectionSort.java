package base.chass01;

import java.util.Arrays;

/**
 * 比较器思想
 */
public class Code01_SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, minIndex, i);
        }
    }

    //    private static void swap(int[] arr, int i, int minIndex) {
//        int tmp = arr[i];
//        arr[i] = arr[minIndex];
//        arr[minIndex] = tmp;
//    }
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int testTime=500000;
        int maxSize=100;
        int maxValue=100;
        boolean succed=true;
        for (int i = 0; i < testTime; i++) {
            int []arr1=generateRandomArray(maxSize,maxValue);
            int []arr2=copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1,arr2)){
                succed=false;
                printArray(arr1);
                printArray(arr2);
                break;
            }

        }
    }

    private static void comparator(int[] arr2) {
        Arrays.sort(arr2);
    }

    private static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]+",");
        }
    }

    private static int[] copyArray(int[] arr1) {
        int []arr2=new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i]=arr1[i];
        }
        return arr2;
    }

    public static int[]generateRandomArray(int maxSize,int maxValue){
        int []arr=new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)((maxValue+1)*Math.random()-(int)(maxValue*Math.random()));
        }
        return arr;

    }
    public static boolean isEqual(int []arr1,int []arr2){
        if(arr1==null && arr2!=null||
        arr1!=null && arr2==null){
            return false;
        }
        if(arr1==null&&arr2==null ){
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
