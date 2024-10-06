package leetcode.a1800;

import java.util.PriorityQueue;

/**
 * 1845. 座位预约管理系统
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个管理 size 个座位预约的系统，座位编号从 1 到 size 。
 * <p>
 * 请你实现 SeatManager 类：
 * <p>
 * SeatManager(int size) 初始化一个 SeatManager 对象，它管理从 1 到 size 编号的 size 个座位。所有座位初始都是可预约的。
 * int reserve() 返回可以预约座位的 最小编号 ，此座位变为不可预约。
 * void unreserve(int seatNumber) 将给定编号 seatNumber 对应的座位变成可以预约。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
 * [[5], [], [], [2], [], [], [], [], [5]]
 * 输出：
 * [null, 1, 2, null, 2, 3, 4, 5, null]
 * <p>
 * 解释：
 * SeatManager seatManager = new SeatManager(5); // 初始化 SeatManager ，有 5 个座位。
 * seatManager.reserve();    // 所有座位都可以预约，所以返回最小编号的座位，也就是 1 。
 * seatManager.reserve();    // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
 * seatManager.unreserve(2); // 将座位 2 变为可以预约，现在可预约的座位为 [2,3,4,5] 。
 * seatManager.reserve();    // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
 * seatManager.reserve();    // 可以预约的座位为 [3,4,5] ，返回最小编号的座位，也就是 3 。
 * seatManager.reserve();    // 可以预约的座位为 [4,5] ，返回最小编号的座位，也就是 4 。
 * seatManager.reserve();    // 唯一可以预约的是座位 5 ，所以返回 5 。
 * seatManager.unreserve(5); // 将座位 5 变为可以预约，现在可预约的座位为 [5] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= size <= 105
 * 1 <= seatNumber <= size
 * 每一次对 reserve 的调用，题目保证至少存在一个可以预约的座位。
 * 每一次对 unreserve 的调用，题目保证 seatNumber 在调用函数前都是被预约状态。
 * 对 reserve 和 unreserve 的调用 总共 不超过 105 次。
 */
public class M1845SeatManager {
    private static class SeatManager {
        PriorityQueue queue = new PriorityQueue<Integer>();
        public SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }
        }

        public int reserve() {
            return (int) queue.poll();
        }

        public void unreserve(int seatNumber) {
            queue.add(seatNumber);
        }
    }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(size);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
