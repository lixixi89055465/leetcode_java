package ZJ;

/**
 * @author lixiang
 * data 2023/7/28
 */

import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
 * <p>
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 * <p>
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [2,8]
 * 示例 3:
 * <p>
 * 输入: 3
 * 输出: [3,8,10]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 105
 * <p>
 * <p>
 * 进阶:
 * <p>
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 */
public class ZJ470 {
    private static class Solution {
        public int rand10() {
            int res = 10;
            while (res >= 10) {
                res = 0;
                for (int i = 0; i < 4; i++) {
                    res <<= 2;
                    res += getOne() ? 1 : 0;
                }
            }
            return res + 1;
        }

        private boolean getOne() {
            int res = 0;
            while (true) {
                res = rand7();
                if (res > 4) {
                    return true;
                } else if (res < 4) {
                    return false;
                }
            }
        }

        private int rand7() {
            return new Random().nextInt(7) + 1;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        for (int i = 0; i < 1000; i++) {
            int res=solve.rand10();
            if(res>10||res<1){
                System.out.println("Error");
            }
        }
    }
}
