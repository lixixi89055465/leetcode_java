package leetcode.a300;

import java.util.LinkedList;

public class Test01 {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(1);
        stack.addFirst(2);
        System.out.println(stack.pollFirst());
    }

}
