package leetcode.mst;

/**
 * 面试题 16.03. 交点
 * 提示
 * 困难
 * 84
 * 相关企业
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 * 示例 1：
 * 输入：
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * 输出： {0.5, 0}
 * 示例 2：
 * <p>
 * 输入：
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * 输出： {1, 1}
 * 示例 3：
 * <p>
 * 输入：
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * 输出： {}，两条线段没有交点
 * <p>
 * <p>
 * 提示：
 * <p>
 * 坐标绝对值不会超过 2^7
 * 输入的坐标均是有效的二维坐标
 * y=(y1-y2)/(x1-x2)*x+b
 * Ax+By+c=0
 * y=ax+b;
 */
public class H1603intersection {
    private static class Solution {
        public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
            double A = Double.MAX_VALUE, B = Double.MAX_VALUE, C = Double.MAX_VALUE;
            if (start1[0] == end1[0]) {
                A = 1;
                C = -start1[0];
            } else {
                B = 1;
                A = (start1[1] - end1[1]) / (start1[0] - end1[0]);
                C = -(A * start1[0] + B * start1[1]);
            }



            return null;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] start1 = {0, 0};
        int[] end1 = {1, 0};
        int[] start2 = {1, 1};
        int[] end2 = {0, -1};
        System.out.println(solve.intersection(start1, end1, start2, end2));
    }
}
