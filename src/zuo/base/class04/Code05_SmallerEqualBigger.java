package zuo.base.class04;

/**
 *将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】给定一个单链表的头节点head，节点的值类型是整型，再给定一个整
 * 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的
 * 节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
 * 【进阶】在实现原问题功能的基础上增加如下的要求
 * 【要求】调整后所有小于pivot的节点之间的相对顺序和调整前一样
 * 【要求】调整后所有等于pivot的节点之间的相对顺序和调整前一样
 * 【要求】调整后所有大于pivot的节点之间的相对顺序和调整前一样
 * 【要求】时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 */
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
