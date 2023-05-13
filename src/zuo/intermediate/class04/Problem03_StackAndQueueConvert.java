package zuo.intermediate.class04;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Problem03_StackAndQueueConvert {

    private static class TwoQueueStack {
        private Queue<Integer> queuePush = new LinkedBlockingQueue<>();
        private Queue<Integer> queuePop = new LinkedBlockingQueue<>();

        public void push(int value) {
            queuePush.add(value);
        }

        public int poll() {
            if (queuePush.isEmpty() && queuePop.isEmpty()) {
                throw new RuntimeException("queue is empty!");
            }
            if (!queuePush.isEmpty()) {
                while (queuePush.size() > 1) {
                    queuePop.add(queuePush.poll());
                }
                return queuePush.poll();
            } else {
                while (queuePop.size() > 1) {
                    queuePush.add(queuePop.poll());
                }
                return queuePop.poll();
            }
        }

        public int peek() {
            if (queuePush.isEmpty() && queuePop.isEmpty()) {
                throw new RuntimeException("queue is empty!");
            }
            if (!queuePush.isEmpty()) {
                while (queuePush.size() > 1) {
                    queuePop.add(queuePush.poll());
                }
                return queuePush.peek();
            } else {
                while (queuePop.size() > 1) {
                    queuePush.add(queuePop.poll());
                }
                return queuePop.peek();
            }
        }
    }

    private static class TwoStackQueue {
        private Stack<Integer> stackPush = new Stack<>();
        private Stack<Integer> stackPop = new Stack<>();

        public void push(int value) {
            stackPush.push(value);
            dao();
        }

        public int poll() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is Empy ");
            }
            dao();
            return stackPush.peek();
        }

        public void dao() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }
}
