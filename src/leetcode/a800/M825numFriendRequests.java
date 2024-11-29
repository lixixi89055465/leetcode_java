package leetcode.a800;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/11/18 10:19
 * @description：https://leetcode.cn/problems/friends-of-appropriate-ages/?envType=daily-question&envId=2024-11-17
 * @modifiedBy：
 * @version: 1.0
 * 825. 适龄的朋友
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 * <p>
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 * <p>
 * ages[y] <= 0.5 * ages[x] + 7
 * ages[y] > ages[x]
 * ages[y] > 100 && ages[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 * <p>
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 * <p>
 * 返回在该社交媒体网站上产生的好友请求总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * 示例 2：
 * <p>
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * 示例 3：
 * <p>
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == ages.length
 * 1 <= n <= 2 * 104
 * 1 <= ages[i] <= 120
 */
public class M825numFriendRequests {
    private static class Solution {
        public int numFriendRequests(int[] ages) {
            Arrays.sort(ages);


            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
