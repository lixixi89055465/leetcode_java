package leetcode.mst;

import java.security.cert.TrustAnchor;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

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
 * <p>
 * <p>
 * <p>
 * start1 =
 * [0,0]
 * end1 =
 * [0,1]
 * start2 =
 * [0,2]
 * end2 =
 * [0,3]
 * {}
 */
public class H1603intersection {
    private static class Solution {
        public double[] intersection(int[] node1, int[] node2, int[] node3, int[] node4) {
            double t = (node4[1] - node3[1]) * (node2[0] - node1[0]) - (node4[0] - node3[0]) * (node2[1] - node1[1]);
            if (t != 0) {
                double t1 = 1.0 * (node3[0] * (node4[1] - node3[1])
                        + node1[1] * (node4[0] - node3[0])
                        - node3[1] * (node4[0] - node3[0])
                        - node1[0] * (node4[1] - node3[1])) / t;
                double t2 = -1.0 * (node1[0] * (node2[1] - node1[1])
                        + node3[1] * (node2[0] - node1[0])
                        - node1[1] * (node2[0] - node1[0])
                        - node3[0] * (node2[1] - node1[1])) / t;
                if (0 <= t1 && t1 <= 1 && 0 <= t2 && t2 <= 1) {
                    return new double[]{node1[0] + t1 * (node2[0] - node1[0]), node1[1] + t1 * (node2[1] - node1[1])};
                }
                return new double[]{};
            } else {
                if (node1[0] == node2[0] && node1[0] == node3[0] && node1[0] == node4[0]) {
                    double[] res = {node1[0], Integer.MAX_VALUE};
                    boolean flag = false;
                    t = 1.0 * (node3[1] - node1[1]) / (node2[1] - node1[1]);
                    if (0 <= t && t <= 1.0) {
                        flag = true;
                        res[1] = Math.min(node3[1], res[1]);
                    }
                    t = 1.0 * (node4[1] - node1[1]) / (node2[1] - node1[1]);
                    if (0 <= t && t <= 1.0) {
                        flag = true;
                        res[1] = Math.min(node4[1], res[1]);
                    }
                    t = 1.0 * (node1[1] - node3[1]) / (node4[1] - node3[1]);
                    if (0 <= t && t <= 1.0) {
                        flag = true;
                        res[1] = Math.min(node1[1], res[1]);
                    }
                    t = 1.0 * (node2[1] - node3[1]) / (node4[1] - node3[1]);
                    if (0 <= t && t <= 1.0) {
                        flag = true;
                        res[1] = Math.min(node2[1], res[1]);
                    }
                    if (!flag) {
                        return new double[]{};
                    }
                    return res;
                } else {
                    t = (node2[1] - node1[1]) * (node3[0] - node1[0]) -
                            (node3[1] - node1[1]) * (node2[0] - node1[0]);
                    if (t != 0) {
                        return new double[]{};
                    }
                    int[] res = {Integer.MAX_VALUE, Integer.MAX_VALUE};
                    boolean flag = false;
                    t = 1.0 * (node1[0] - node4[0]) / (node3[0] - node4[0]);
                    if (0 <= t && t <= 1.0) {
                        flag = true;
                        res = node1;
                    }

                    t = 1.0 * (node2[0] - node4[0]) / (node3[0] - node4[0]);
                    if (0 <= t && t <= 1.0) {
                        flag = true;
                        res = isMin(node2, res);
                    }
                    t = 1.0 * (node3[0] - node1[0]) / (node2[0] - node1[0]);
                    if (0 <= t && t <= 1.0) {
                        flag = true;
                        res = isMin(node3, res);
                    }
                    t = 1.0 * (node4[0] - node1[0]) / (node2[0] - node1[0]);
                    if (0 <= t && t <= 1.0) {
                        flag = true;
                        res = isMin(node4, res);
                    }
                    if (!flag) {
                        return new double[]{};
                    }
                    return new double[]{res[0], res[1]};
                }
            }
        }

        private int[] isMin(int[] t, int[] res) {
            if (t[0] < res[0]) {
                return t;
            } else if (t[0] > res[0]) {
                return res;
            } else {
                return t[1] > res[1] ? res : t;
            }
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] start1 = {0, 0};
//        int[] end1 = {1, 0};
//        int[] start2 = {1, 1};
//        int[] end2 = {0, -1};

//        int[] start1 = {0, 0};
//        int[] end1 = {3, 3};
//        int[] start2 = {1, 1};
//        int[] end2 = {2, 2};

//        int[] start1 = {0, 0};
//        int[] end1 = {1, 1};
//        int[] start2 = {1, 0};
//        int[] end2 = {2, 1};

//        int[] start1 = {0, 3};
//        int[] end1 = {0, 6};
//        int[] start2 = {0, 1};
//        int[] end2 = {0, 5};

//        int[] start1 = {0, 0};
//        int[] end1 = {0, 1};
//        int[] start2 = {0, 2};
//        int[] end2 = {0, 3};
        int[] start1 = {0, 0};
        int[] end1 = {1, 1};
        int[] start2 = {2, 2};
        int[] end2 = {3, 3};
        double[] res = solve.intersection(start1, end1, start2, end2);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()).stream().map(Objects::toString).collect(Collectors.joining(",")));
    }
}
