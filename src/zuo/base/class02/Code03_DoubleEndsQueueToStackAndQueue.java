package zuo.base.class02;

/**
 * 链表删除
 */
public class Code03_DoubleEndsQueueToStackAndQueue {

    public static class Node<T> {
        public T value;
        public Node pre;
        public Node next;

        public Node(T data) {
            this.value = data;
        }
    }

    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
        }

        public void addFromBottom(T value) {
            Node<T> cur = new Node<>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.pre = tail;
                tail = cur;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public Node<T> popFromBottom() {
            Node<T> cur = null;
            Node<T> pre=tail.pre;
            pre.next=null;
            tail.pre=null;
            return tail;
        }
    }

    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public Node<T> pop(T value) {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public Node<T> poll(T value) {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
