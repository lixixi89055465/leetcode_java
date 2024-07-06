package zuo.base.chass01;

import utils.RandomUtils;

import java.util.Arrays;

/**
 * 比较器思想
 */
public class Code01_SelectionSort {
	public static void selectSort(int[] arr){
		if(arr==null||arr.length<2){
			return;
		}
		for (int i = 0; i < arr.length-1; i++) {
			int minIndex=i;
			for (int j = i+1; j < arr.length; j++) {
				minIndex=arr[minIndex]>arr[j]?j:minIndex;
			}
			swap(arr,i,minIndex);
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
	}

	public static void main(String[] args) {
		int[] arr = RandomUtils.generateRandomArray(100, 100);
		int[] copyArr = RandomUtils.copyArray(arr);
		selectSort(arr);
		Arrays.sort(copyArr);
		System.out.println(RandomUtils.isEqual(arr, copyArr));

	}

}
