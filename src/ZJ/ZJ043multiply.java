package ZJ;

/**
 * 43. 字符串相乘
 * 中等
 * 1.2K
 * 相关企业
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 */
public class ZJ043multiply {
    private static class Solution {
        public String multiply(String num1, String num2) {
            if("0".equals(num1)||"0".equals(num2)){
                return  "0";
            }
            char[] chs1 = new StringBuilder(num1).reverse().toString().toCharArray();
            char[] chs2 = new StringBuilder(num2).reverse().toString().toCharArray();
            int n = chs1.length + chs2.length ;
            int[] res = new int[n];
            for (int i = 0; i <chs1.length; i++) {
                for (int j = 0; j <chs2.length; j++) {
                    addCha(res, chs1[i], i, chs2[j], j , n);
                }
            }
            StringBuilder sb = new StringBuilder();
            if(res[res.length-1]!=0){
                sb.append(res[res.length-1]);
            }
            for (int i = res.length-2; i >=0 ; i--) {
                sb.append(res[i]);
            }
            return sb.toString();
        }

        private void addCha(int[] res, char c1, int i, char c2, int j, int n) {
            int t1 = c1 - '0';
            int t2 = c2 - '0';
            int t3 = t1 * t2;
            int i1 = i + j;
            res[i1] += t3;
            int start = i1;
            while (start < n - 1) {
                if (res[start] < 10) {
                    break;
                }
                res[start + 1] += res[start] / 10;
                res[start] = res[start] % 10;
                start++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        String num1 = "123", num2 = "456";
        String num1 = "2", num2 = "3";
        String res = solve.multiply(num1, num2);
        System.out.println(res);
    }
}
