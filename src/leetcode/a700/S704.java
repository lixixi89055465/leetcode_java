package leetcode.a700;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月26日 10:55
 * 项目名称: leetcode_java
 * 文件名称: S704
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright:
 */

public class S704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (mid == nums[l]) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if(target!=nums[l]){
            return -1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        S704 s704 = new S704();
        int res = s704.search(nums, target);
        System.out.println(res);


    }
}
