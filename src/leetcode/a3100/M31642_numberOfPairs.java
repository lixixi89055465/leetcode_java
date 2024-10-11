package leetcode.a3100;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建人:  @author xxxxxx
 * 创建时间:  2024年10月11日 10:21
 * 项目名称:  leetcode_java
 * 文件名称:  M31642_numberOfPairs
 * 文件描述:  @Description:
 * 公司名称:
 * <p>
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright: 2021-2024
 * <p>
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 3164. 优质数对的总数 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 * <p>
 * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 * <p>
 * 返回 优质数对 的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 2个优质数对分别是 (3, 0) 和 (3, 1)。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, m <= 105
 * 1 <= nums1[i], nums2[j] <= 106
 * 1 <= k <= 103
 */
public class M31642_numberOfPairs {
    private static class Solution {
        public long numberOfPairs(int[] nums1, int[] nums2, int k) {

            Map<Integer, Integer> count = new HashMap<Integer, Integer>();
            Map<Integer, Integer> count2 = new HashMap<Integer, Integer>();
            int max1 = 0;
            for (int num : nums1) {
                count.put(num, 1 + count.getOrDefault(num, 0));
                max1 = Math.max(max1, num);
            }
            for (int num : nums2) {
                count2.put(num, 1 + count2.getOrDefault(num, 0));
            }
            long res = 0;
            for (Integer a : count2.keySet()) {
                for (int b = a * k; b <= max1; b += a * k) {
                    if (count.containsKey(b)) {
                        res += 1L * count.get(b) * count2.get(a);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
