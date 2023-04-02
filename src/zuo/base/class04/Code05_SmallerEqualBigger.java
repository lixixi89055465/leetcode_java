package zuo.base.class04;

public class Code05_SmallerEqualBigger {
    private static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node cur = head;
        while (cur != null) {
            if (cur.value < pivot) {
                if (sH == null) {
                    sH = cur;
                    sT = cur;
                } else {
                    sT.next = cur;
                    sT = cur;
                }

            } else if (cur.value == pivot) {
                if (mH == null) {
                    mH = cur;
                    mT = cur;
                } else {
                    mT.next = cur;
                    mT = cur;
                }
            } else {
                if (eH == null) {
                    eH = cur;
                    eT = cur;
                } else {
                    eT.next = cur;
                    eT = cur;
                }
            }
        }
        if (sH != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }

    public static void main(String[] args) {

    }
}
