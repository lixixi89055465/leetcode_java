package ZJ;

/**
 * @author lixiang
 * data 2023/7/27
 */
public class ZJ019removeNthFromEnd {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode root = new ListNode(-1);
            root.next = head;
            ListNode pre = root;
            ListNode right = head;
            for (int i = 0; i < n; i++) {
                if (head == null) {
                    return null;
                }
                right = right.next;
            }
            ListNode left = head;
            while (right != null) {
                pre = left;
                left = left.next;
                right = right.next;
            }
            pre.next = left.next;
            return root.next;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, null));
        Solution solve = new Solution();
        ListNode res = solve.removeNthFromEnd(root, 2);
        System.out.println(res.val);
    }
}
