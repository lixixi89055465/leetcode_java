package test01;

import java.util.ArrayList;
import java.util.List;


/**
 * 创建人: @author lixiang
 * 创建时间: 2025年09月08日 20:16
 * 项目名称: leetcode_java
 * 文件名称: Solve01
 * 文件描述: @Description:
 * site:
 * <p>
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * <p>
 * 示例 2：
 * 输入：mat = [
 * [1,2,3,4,5],
 * [6,7,8,9,10],
 * [11,12,13,14,15]
 * ]
 * 输出：[1,2,6,11,7,3,
 * 4,8,12,
 * 13,9,5,10,14,15]
 * class Solution {
 * public int[] findDiagonalOrder(int[][] mat) {
 * int m = mat.length;
 * int n = mat[0].length;
 * int[] res = new int[m * n];
 * int pos = 0;
 * for (int i = 0; i < m + n - 1; i++) {
 * if (i % 2 == 1) {
 * int x = i < n ? 0 : i - n + 1;
 * int y = i < n ? i : n - 1;
 * while (x < m && y >= 0) {
 * res[pos] = mat[x][y];
 * pos++;
 * x++;
 * y--;
 * }
 * } else {
 * int x = i < m ? i : m - 1;
 * int y = i < m ? 0 : i - m + 1;
 * while (x >= 0 && y < n) {
 * res[pos] = mat[x][y];
 * pos++;
 * x--;
 * y++;
 * }
 * }
 * }
 * return res;
 * }
 * }
 * <p>
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/diagonal-traverse/solutions/1597961/dui-jiao-xian-bian-li-by-leetcode-soluti-plz7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solve01 {
    public int[] process(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos]=mat[x][y];
                    x--;
                    y++;
                }
            } else if (i % 2 == 1) {
                int x=i<n?0:i-n+1;
                int y=i<n?i:n-1;
                while (x < m && y >=0) {
                    res[pos]=mat[x][y];
                    x++;
                    y--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        Solve01 solve01 = new Solve01();
//        List<Integer> res = solve01.process(mat);
//        for (Integer re : res) {
//            System.out.print(re + ",");
//        }
    }
}
