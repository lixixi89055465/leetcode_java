package zuo.intermediate.class02;

import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class test1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        Stack<Integer> result = process(stack);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static Stack process(Stack<Integer> stack) {
        Stack<Integer> cache = new Stack<>();
        Stack<Integer> result = new Stack<>();
        while (!stack.isEmpty()) {
            Integer peek = stack.pop();
            if (cache.isEmpty() || peek <= cache.peek()) {
                cache.push(peek);
            } else {
                while (!cache.isEmpty() && peek > cache.peek())
                    stack.push(cache.pop());
                cache.push(peek);
            }
        }
        return cache;

    }
}
