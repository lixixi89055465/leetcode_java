package leetcode.a1300;

import java.security.cert.CertificateNotYetValidException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * <p>
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。在任意一天 d 中只能参加一场会议。
 * <p>
 * 请你返回你可以参加的 最大 会议数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 * <p>
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= events.length <= 105
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 105
 */
public class M1353 {
    public int maxEvents(int[][] events) {
        int n = events.length;
        int maxday = 0;
        for (int[] event : events) {
            maxday = Math.max(maxday, event[1]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 1, j = 0; i <= maxday; i++) {
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] events = {{1, 2}, {2, 3}, {3, 4}};
//        int[][] events = {{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
//        int[][] events = {{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}};
//        int[][] events = {{1, 2}, {1, 2}, {1, 6}, {1, 2}, {1, 2}};
//        int[][] events = {{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}};
        int[][] events =
                {{27, 27}, {8, 10}, {9, 11}, {20, 21}, {25, 29}, {17, 20}, {12, 12}, {12, 12}, {10, 14}, {7, 7}, {6, 10}, {7, 7}, {4, 8}, {30, 31}, {23, 25}, {4, 6}, {17, 17}, {13, 14}, {6, 9}, {13, 14}};
        M1353 s = new M1353();
        int res = s.maxEvents(events);
        System.out.println(res);
    }
}
