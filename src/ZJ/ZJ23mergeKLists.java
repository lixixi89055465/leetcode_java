package ZJ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ZJ23mergeKLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    private static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> stack = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for (int i = 0; i < lists.length; i++) {
                if(lists[i]!=null){
                    stack.add(lists[i]);
                }
            }
            ListNode head = new ListNode(0,null);
            ListNode tail = head;
            while (!stack.isEmpty()) {
                ListNode top = stack.poll();
                if (top.next!=null) {
                    stack.add(top.next);
                }
                tail.next = top;
                tail=tail.next;
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode3 = new ListNode(2, new ListNode(6, null));
        Solution solve = new Solution();
        System.out.println(solve.mergeKLists(new ListNode[]{listNode1, listNode2, listNode3}));
    }
}
