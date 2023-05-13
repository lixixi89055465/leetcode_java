package zuo.intermediate.class04;

import java.util.Stack;

public class StackMin {
    private Stack<Integer> valueStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void add(int value) {
        valueStack.add(value);
        if (minStack.isEmpty() || minStack.peek() < value) {
            minStack.add(minStack.peek());
        } else {
            minStack.add(value);
        }
    }

    public int getMin() {
        return minStack.peek();
    }

    public int pop() {
        return valueStack.pop();
    }

    public static void main(String[] args) {

    }
}
