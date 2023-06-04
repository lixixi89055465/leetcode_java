package zuo.senior.class04;


public class Problem06_BFPRT {
    private static int select(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return 0;
        }
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (pivotRange[0] > i) {
            return select(arr, begin, pivotRange[0] - 1, i);
        } else if (pivotRange[1] < i) {
            return select(arr, pivotRange[1] + 1, end, i);
        } else {
            return arr[i];
        }
    }

    private static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int big = end;
        int cur = begin;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, cur++, ++small);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, big--);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small;
        range[1] = big;
        return range;
    }

    private static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, endI);
        }
        return select(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = begin + end;
        int index = sum / 2 + (sum % 2);
        return arr[index];
    }

    private static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i <= end; i++) {
            for (int j = i; j >= begin; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
