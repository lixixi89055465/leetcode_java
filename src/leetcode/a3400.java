package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3440. 重新安排会议得到最多空余时间 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
 * <p>
 * 同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
 * <p>
 * 你可以重新安排 至多 一个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 最长 连续空余时间。
 * <p>
 * 请你返回重新安排会议以后，可以得到的 最大 空余时间。
 * <p>
 * 注意，会议 不能 安排到整个活动的时间以外，且会议之间需要保持互不重叠。
 * <p>
 * 注意：重新安排会议以后，会议之间的顺序可以发生改变。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：eventTime = 5, startTime = [1,3], endTime = [2,5]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 将 [1, 2] 的会议安排到 [2, 3] ，得到空余时间 [0, 2] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 将 [0, 1] 的会议安排到 [8, 9] ，得到空余时间 [0, 7] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 将 [3, 4] 的会议安排到 [8, 9] ，得到空余时间 [1, 7] 。
 * <p>
 * 示例 4：
 * <p>
 * 输入：eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 活动中的所有时间都被会议安排满了。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= eventTime <= 109
 * n == startTime.length == endTime.length
 * 2 <= n <= 105
 * 0 <= startTime[i] < endTime[i] <= eventTime
 * endTime[i] <= startTime[i + 1] 其中 i 在范围 [0, n - 2] 之间。
 */
public class a3400 {
    private class Node {
        private int size;
        private int index;//0-空，1-会议

        public Node(int size, int index) {
            this.size = size;
            this.index = index;
        }
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.size - o2.size;
            }
        });
        int pre = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (pre < startTime[i]) {
                Node node = new Node(startTime[i] - pre, i);
                queue.add(node);
            }
            pre=endTime[i];
        }
        if (!queue.isEmpty()) {
            return 0;
        }
        int res = queue.peek().size;
        pre=0;
        for (int i = 0; i <startTime.length; i++) {
            if(startTime[i]>pre){
            }
            pre=endTime[i];

        }


        return 0;
    }

    public static void main(String[] args) {

    }
}
