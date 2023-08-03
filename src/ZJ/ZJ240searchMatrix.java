package ZJ;

/**
 * @author lixiang
 * data 2023/7/28
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]],
 * target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 */
public class ZJ240searchMatrix {
    private static class Solution {
        public boolean searchMatrix01(int[][] matrix, int target) {
            int x = 0, y = matrix[0].length - 1;
            while (true) {
                while (matrix[x][y] > target) {
                    if (y == 0) {
                        return false;
                    }
                    y -= 1;
                }
                while (matrix[x][y] < target) {
                    if (x == matrix.length - 1) {
                        return false;
                    }
                    x += 1;
                }
                if (matrix[x][y] == target) {
                    return true;
                }
            }
        }

        public boolean searchMatrix02(int[][] matrix, int target) {
            int x = 0, y = matrix[0].length - 1;
            int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
            while (true) {
                boolean flag=false;
                if(left<right) {
                    int tmpright = findColLowMid(matrix, top, left, right, target);
                    if (tmpright != right) {
                        right=tmpright;
                        flag=true;
                    }
                    int tmpleft = findColHighMid(matrix, bottom, left, right, target);
                    if (tmpleft!= left) {
                        left=tmpright;
                        flag=true;
                    }
                }
                if(top<bottom) {
                    int tmpbottom = findRowLowMid(matrix, left, top, bottom, target);
                    if (tmpbottom != bottom) {
                        bottom=tmpbottom;
                        flag=true;
                    }
                    int tmptop= findRowHighMid(matrix, right, top, bottom, target);
                    if (tmptop != top) {
                        top=tmptop;
                        flag=true;
                    }
                }
                if(matrix[top][left]==target){
                    return true;
                }
                if(left>=right&&top>=bottom){
                    break;
                }
                if(!flag){
                    break;
                }
            }
            if(matrix[top][left]==target){
                return true;
            }
            while (left<=right&&top<=bottom){
                while (matrix[top][right] > target) {
                    if (right == left) {
                        return false;
                    }
                    right-= 1;
                }
                while (matrix[top][right] < target) {
                    if (top == bottom ) {
                        return false;
                    }
                    top += 1;
                }
                if (matrix[top][right] == target) {
                    return true;
                }
            }
            return false;
        }

        private int findRowHighMid(int[][] matrix, int right, int top, int bottom, int target) {

            while (top < bottom) {
                int mid = top + (bottom - top) / 2;
                if (matrix[mid][right] < target) {
                    top = mid + 1;
                } else if (matrix[mid][right] > target) {
                    bottom = mid;
                } else {
                    return mid;
                }
            }
            return top ;
        }

        private int findColHighMid(int[][] matrix, int bottom, int left, int right, int target) {
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (matrix[bottom][mid] < target) {
                    left = mid + 1;
                } else if (matrix[bottom][mid] > target) {
                    right = mid;
                } else {
                    return mid;
                }
            }
            return left;
        }

        private int findRowLowMid(int[][] matrix, int left, int top, int bottom, int target) {
            bottom+=1;
            while (top < bottom) {
                int mid = top + (bottom - top) / 2;
                if (matrix[mid][left] < target) {
                    top = mid + 1;
                } else if (matrix[mid][left] > target) {
                    bottom = mid;
                } else {
                    return mid;
                }
            }
            return top-1;
        }

        private int findColLowMid(int[][] matrix, int x, int left, int right, int target) {
            right+=1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (matrix[x][mid] < target) {
                    left = mid + 1;
                } else if (matrix[x][mid] > target) {
                    right = mid;
                } else {
                    return mid;
                }
            }
            return left-1;
        }

    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
//        int target = 30;
//        int target = 29;
//        int target = 18;
//        int target = 1;
//        int target = 7;
//        int target = 15;
//        int target = 28;
//        int target = 27;
//        int target = 24;
//        int target = 0;
//        int [][]matrix={{1,1}};
//        int target=1;
//        for (int i = 0; i < 19; i++) {
//            int [][]matrix={{5,6,9},{9,10,11},{11,14,18}};
//            int target=i;
//            System.out.print(i+":");
//            boolean res = solve.searchMatrix02(matrix, target);
//            System.out.println(res);
//        }
            int [][]matrix={{5,6,9},{9,10,11},{11,14,18}};
            int target=14;
            boolean res = solve.searchMatrix02(matrix, target);
            System.out.println(res);
    }
}
