package leetcode.mst;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @PackageName:leetcode.mst
 * @Date 2023/8/24 19:13
 * @Description: https://leetcode.cn/problems/continuous-median-lcci/
 * <p>
 * 面试题 17.20. 连续中值
 * 提示
 * 困难
 * 37
 * 相关企业
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 * <p>
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class H1720MedianFinder {
    private static class MedianFinder {
        private Queue<Integer> minStack = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        private Queue<Integer> maxStack = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
        }

        public void addNum(int num) {
            if (maxStack.isEmpty()) {
                maxStack.add(num);
                return;
            }
            if (maxStack.peek() < num) {
                maxStack.add(num);
            } else {
                minStack.add(num);
            }
            if (minStack.size() + 1 < maxStack.size()) {
                minStack.add(maxStack.poll());
            }
            if (minStack.size() > maxStack.size()) {
                maxStack.add(minStack.poll());
            }
        }

        public double findMedian() {
            if (maxStack.size() == 0) {
                throw new RuntimeException("没有数据");
            }
            if (maxStack.size() == minStack.size()) {
                return (maxStack.peek() + minStack.peek()) / 2.0;
            } else {
                return maxStack.peek() * 1.0;
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
//        obj.addNum();
    }
}
