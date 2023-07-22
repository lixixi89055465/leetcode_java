package ZJ;

import java.util.*;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class ZJ56merge {
    private static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> res = new ArrayList<>();
            res.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= res.get(res.size() - 1)[1]
                        && res.get(res.size() - 1)[1] < intervals[i][1]) {
                    res.get(res.size() - 1)[1] = intervals[i][1];
                } else if (res.get(res.size() - 1)[1] < intervals[i][0]) {
                    res.add(intervals[i]);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution solve = new Solution();
        int[][] res = solve.merge(intervals);
        System.out.println(res);
    }
}

