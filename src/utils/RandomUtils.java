package utils;

import java.util.Arrays;

public class RandomUtils {
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		if(arr.length==1){
			System.out.println(arr[0]);
		}
		for (int i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length-1]);
	}
	public static void swap(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	public static void swapBit(int[] arr, int i, int j) {
		arr[i]=arr[i]^arr[j];
		arr[j]=arr[i]^arr[j];
		arr[i]=arr[i]^arr[j];
	}

	public static void sort(int[] arr) {
		Arrays.sort(arr);
	}
}
