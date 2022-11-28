package leetcode.a800;


public class H862shortestSubarray {
    static class Pair {
        public int maxSize;
        public int maxValue;

        public Pair(int maxSize, int maxValue) {
            this.maxSize = maxSize;
            this.maxValue = maxValue;

        }
    }

    static class Solution {
        public int shortestSubarray(int[] nums, int k) {
            return 0;
        }

        public int shortestSubarray1(int[] nums, int k) {
            Pair maxSize = process1(nums, 0, 0, 0, k);
            return maxSize == null ? -1 : maxSize.maxSize;
        }

        private Pair process1(int[] nums, int index, int numSum, int numSize, int k) {
            if (index == nums.length) {
                return null;
            }
            Pair p1 = null;
            if (numSum + nums[index] >= k) {
                p1 = new Pair(numSize + 1, numSum + nums[index]);
            } else {
                p1 = process1(nums, index + 1, numSum + nums[index], numSize + 1, k);
            }
            Pair p2 = process1(nums, index + 1, numSum, numSize, k);
            if (p1 == null && p2 == null) {
                return null;
            } else if (p1 == null) {
                return p2;
            } else if (p2 == null) {
                return p1;
            } else {
                return p1.maxSize > p2.maxSize ? p2 : p1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int []nums = {2,-1,2};
//        int k = 3;
//        int []nums = {1,2};
//        int k = 4;
        int []nums = {1};
        int k = 1;
//        int []nums={17,85,93,-45,-21};
//        int k=150;
//        int[] nums = {48, 99, 37, 4, -31};
//        int k = 140;
        int result = solution.shortestSubarray1(nums, k);
        System.out.println(result);
    }
}
