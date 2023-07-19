package ZJ;

public class ZJ004findMedianSortedArrays {
    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int allLen = nums1.length + nums2.length;
            int end1 = nums1.length - 1;
            int end2 = nums2.length - 1;
            int start1 = 0;
            int start2 = 0;
            int index1 = 0;
            int index2 = 0;
            while (start1 < end1) {
                index1 = (end1 + start1) / 2;
                index2 = (end2 + start2) / 2;
                int v1 = nums1[index1];
                int v2 = nums2[index2];
                if (v1 <= v2) {
                    start1 = index1 + 1;
                    end2 = index2;
                } else {
                    start2 = index2 + 1;
                    end1 = index1;
                }
            }

            return 0;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4, 5};
        Solution solve = new Solution();
        System.out.println(solve.findMedianSortedArrays(nums1, nums2));
    }
}
