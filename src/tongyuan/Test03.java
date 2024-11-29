package tongyuan;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/24 20:31
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class Test03 {


    private static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param n int整型
         * @return bool布尔型
         */
        public boolean NimGame(int n) {
            // write code here
            if (n % 4 == 0) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n=100;
//        int n = 5;
        boolean res = solution.NimGame(n);
        System.out.println(res);

    }
}
