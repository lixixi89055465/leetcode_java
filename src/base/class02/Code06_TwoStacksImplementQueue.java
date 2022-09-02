package base.class02;

import java.util.Stack;

/**
 * 链表删除
 */
public class Code06_TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        public void add(int pushInt) {
            this.stackPush.push(pushInt);
            pushToPop();
        }

        private void pushToPop() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
        public int poll(){
            if(stackPop.empty()&&stackPush.empty()){
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }
        public int peek(){
            if(stackPop.empty()&&stackPush.empty()){
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

}
