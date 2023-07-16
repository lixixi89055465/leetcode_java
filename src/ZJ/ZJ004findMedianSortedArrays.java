package ZJ;

public class ZJ004findMedianSortedArrays {
    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int allLen = len1 + len2;
            if ((allLen & 1) == 1) {
                return getKth(nums1, nums2, (allLen + 1) / 2);
            }
            return (getKth(nums1, nums2, (allLen + 1) / 2) +
                    getKth(nums1, nums2, (allLen + 1) / 2 + 1)) / 2;
        }

        private double getKth(int[] nums1, int[] nums2, int K) {
            int end1 = nums1.length - 1;
            int end2 = nums2.length - 1;
            int start1 = 0;
            int start2 = 0;
            while (true) {
                int index1 = (end1 + start1) / 2;
                int index2 = (end2 + start2) / 2;
                int v1 = nums1[index1];
                int v2 = nums2[index2];
                if (K == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }
                if (v1 <= v2) {
                    K = K - (index1 - start1) / 2;
                    start1 = index1;
                    end2 = index2;
                } else {
                    K = K - (index2 - start2) / 2;
                    start2 = index2;
                    end1 = index1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4, 5};
        Solution solve = new Solution();
        System.out.println(solve.findMedianSortedArrays(nums1, nums2));
    }
}
