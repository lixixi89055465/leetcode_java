package a600;


public class M641MyCircularDequeMedium {
    private int[] elements;
    private int rear, front;
    private int capacity;

    public M641MyCircularDequeMedium(int k) {
        capacity = k + 1;
        rear = front = 0;
        elements = new int[k + 1];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }
    public boolean deleteFront(){
        if(isEmpty()){
            return false;
        }
        front=(front+1)%capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        M641MyCircularDequeMedium circularDeque = new M641MyCircularDequeMedium(3); // 设置容量大小为3
        circularDeque.insertLast(1);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true
        circularDeque.insertFront(4);                    // 已经满了，返回 false
        circularDeque.getRear();                // 返回 2
        circularDeque.isFull();                        // 返回 true
        circularDeque.deleteLast();                    // 返回 true
        circularDeque.insertFront(4);                    // 返回 true
        circularDeque.getFront();                // 返回 4

    }
}
