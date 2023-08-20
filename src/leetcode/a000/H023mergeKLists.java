package leetcode.a000;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * 困难
 * 2.6K
 * 相关企业
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class H023mergeKLists {
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
            PriorityQueue<ListNode> stack = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    stack.add(lists[i]);
                }
            }
            ListNode res = new ListNode(-1);
            ListNode head = res;
            while (!stack.isEmpty()) {
                ListNode cur = stack.poll();
                if (cur.next != null) {
                    stack.add(cur.next);
                }
                head.next=cur;
                head=cur ;
            }
            return res.next;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        ListNode[] lists = null;
        System.out.println(solve.mergeKLists(lists));
    }
}
