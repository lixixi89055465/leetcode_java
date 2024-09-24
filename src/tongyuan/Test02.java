package tongyuan;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/24 20:18
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class Test02 {
    private static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param x int整型
         * @return int整型
         */
        public int reverse(int x) {
            // write code here
            int flag = 1;
            if (x < 0) {
                flag = -1;
                x = -x;
            }
            String s = x + "";
            char[] chs = s.toCharArray();
            int left = 0, right = chs.length - 1;
            while (left < right) {
                int tmp = chs[left];
                chs[left] = chs[right];
                chs[right] = (char) tmp;
                left++;
                right--;
            }
            int maxValue = Integer.MAX_VALUE / 10;
            int res = 0;
            for (int i = 0; i < chs.length; i++) {
                if (res > maxValue) {
                    return 0;
                }
                res *= 10;
                res += chs[i] - '0';
            }
            if (flag< 0) {
                return -res;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int n=12;
        int n=1147483649;
        int res=solution.reverse(n);
        System.out.println(res);

    }
}
