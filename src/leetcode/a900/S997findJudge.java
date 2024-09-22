package leetcode.a900;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/22 16:58
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 997. 找到小镇的法官
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 * <p>
 * 如果小镇法官真的存在，那么：
 * <p>
 * 小镇法官不会信任任何人。
 * 每个人（除了小镇法官）都信任这位小镇法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * <p>
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * trust 中的所有trust[i] = [ai, bi] 互不相同
 * ai != bi
 * 1 <= ai, bi <= n
 */
public class S997findJudge {
    private static class Solution {
        public int findJudge(int n, int[][] trust) {
            if (n <= 0) {
                return -1;
            }
            Map<Integer, Integer> parentMap = new HashMap<>();
            for (int i = 0; i < trust.length; i++) {
                parentMap.put(trust[i][0], trust[i][1]);
            }
            Set<Integer> visit = new HashSet<>();
//            LinkedList<Integer> visit=new LinkedList<>() ;
            for (int i = 1; i <= n; i++) {
                visit.clear();
                int temp = i;
                visit.add(i);
                while (parentMap.get(temp) != null) {
                    temp = parentMap.get(temp);
                    if (visit.contains(temp)) {
                        return -1;
                    }
                }
            }
            if (visit.size() > 1) {
                return -1;
            }
            int res = 0;
            for (Integer integer : visit) {
                return integer;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int n = 3;
//        int[][] trust = {{1, 3}, {2, 3}};
//        int n = 4; //3
//        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
//        int n = 3;
//        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        int n = 3;
        int[][] trust = {{1, 2}, {2, 3}};
        int res = solve.findJudge(n, trust);
        System.out.println(res);
    }
}
