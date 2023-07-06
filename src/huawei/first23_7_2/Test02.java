package huawei.first23_7_2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int[] arr = new int[split.length];
//        int[] arr = new int[]{
//                10, 9, 8, 7, 6, 5, 4, 3, 2, 1
//        };
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < right.length; i++) {
            right[i] = n;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                right[stack.peek()] = i ;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = Math.max(tmp, (right[i] - left[i] - 2) * arr[i]);
        }
        System.out.println(tmp);
//6,5,7
//1,6,5,7,8,1

    }
}
