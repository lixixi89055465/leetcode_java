package zuo.senior.class01;

public class Problem04 {
    protected static class Node {
        public Node next;
        public int value;
    }

    public static Node josephusKill2(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        int tmp = 0;
        Node cur = head.next;
        while (cur != null) {
            tmp++;
            cur = cur.next;
        }
        while (--tmp > 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    public static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    public static int no(int i, int[] arr, int index) {
        if (i == 1) {
            return 1;
        }
        return (no(i - 1, arr, nextIndex(arr.length, index)) + arr[index] - 1) % i + 1;
    }

    public static int nextIndex(int size, int index) {
        return size == index + 1 ? 0 : index + 1;
    }

    public static int live(int n, int[] arr) {
        return no(n, arr, 0);
    }
}
