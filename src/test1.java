import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.Scanner;


public class test1 {
    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return pHead;
        }
        ListNode lowl = null, lowr = null, midl = null, midr = null, highl = null, highr = null;
        ListNode head = pHead;
        while (head != null) {
            if (head.val > x) {
                if (lowl == null) {
                    lowl = head;
                    lowr = head;
                } else {
                    lowr.next = head;
                }
            } else if (head.val == x) {
                if (midl == null) {
                    midl = head;
                    midr = head;
                } else {
                    midr.next = head;
                }
            } else {
                if (highl == null) {
                    highl = head;
                    highr = head;
                } else {
                    highr.next = head;
                }
            }
        }
        lowr.next=midl;
        midr.next=midl;
        return pHead;
    }

    public static void main(String[] args) {

    }
}
