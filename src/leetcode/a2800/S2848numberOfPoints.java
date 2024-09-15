package leetcode.a2800;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/15 22:56
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 2848. 与车相交的点
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
 * <p>
 * 返回数轴上被车 任意部分 覆盖的整数点的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[3,6],[1,5],[4,7]]
 * 输出：7
 * 解释：从 1 到 7 的所有点都至少与一辆车相交，因此答案为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,3],[5,8]]
 * 输出：7
 * 解释：1、2、3、5、6、7、8 共计 7 个点满足至少与一辆车相交，因此答案为 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * nums[i].length == 2
 * 1 <= starti <= endi <= 100
 */
public class S2848numberOfPoints {
    private static class Solution {
        public int numberOfPoints(List<List<Integer>> nums) {
            nums.sort(Comparator.comparingInt(o -> o.get(0)));
            List<Integer> pre = new ArrayList<>();
            pre.add(nums.get(0).get(0));
            pre.add(nums.get(0).get(0));
            Integer res = 0;
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> curI = nums.get(i);
                if (curI.get(0) > pre.get(1)) {
                    res += (pre.get(1) - pre.get(0) + 1);
                    pre = curI;
                } else if(curI.get(1)>pre.get(1)){
                    pre.set(1, curI.get(1));
                }
            }
            res += (pre.get(1) - pre.get(0) + 1);
            return res;
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> nums = Arrays.asList(
//                Arrays.asList(3, 6),
//                Arrays.asList(1, 5),
//                Arrays.asList(4, 7)
//        );
        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(4, 4),
                Arrays.asList(9, 10),
                Arrays.asList(9, 10),
                Arrays.asList(3, 8)
        );


        Solution solve = new Solution();
        int res = solve.numberOfPoints(nums);
        System.out.println(res);
    }
}
