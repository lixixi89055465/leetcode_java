package base.class02;

import org.omg.SendingContext.RunTime;

import java.util.Stack;

/**
 * 链表删除
 */
public class Code05_GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int nextNum) {
            if (this.stackData.empty()) {
                this.stackMin.push(nextNum);
            } else if (this.stackMin.peek() <= nextNum) {
                this.stackMin.push(this.stackMin.peek());
            } else {
                this.stackMin.push(nextNum);
            }
            this.stackData.push(nextNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;

        }

        private int getMin() {
            if (this.stackMin.empty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }
    }
}
