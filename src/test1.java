import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.Scanner;


public class test1 {
    public static void main(String[] args) {
        int[] arry = {1,9,5,2,4,8};
        quickSort(arry, 0, arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    public static void quickSort(int[] arry, int left, int right) {
        //运行判断，如果左边索引大于右边是不合法的，直接return结束次方法
        if (left > right) {
            return;
        }
        //定义变量保存基准数
        int base = arry[left];
        //定义变量i，指向最左边
        int i = left;
        //定义j ,指向最右边
        int j = right;
        //当i和j不相遇的时候，再循环中进行检索
        while (i != j) {
            //先由j从右往左检索比基准数小的，如果检索到比基准数小的就停下。
            //如果检索到比基准数大的或者相等的就停下
            while (arry[j] >= base && i < j) {
                j--; //j从右往左检索

            }
            while (arry[i] <= base && i < j) {
                i++; //i从左往右检索
            }
            //代码走到这里i停下，j也停下，然后交换i和j位置的元素
            int tem = arry[i];
            arry[i] = arry[j];
            arry[j] = tem;


        }
        //如果上面while条件不成立就会跳出这个循环，往下执行
        //如果这个条件不成立就说明 i和j相遇了
        //如果i和j相遇了，就交换基准数这个元素和相遇位置的元素
        //把相遇元素的值赋给基准数这个位置的元素
        arry[left] = arry[i];
        //把基准数赋给相遇位置的元素
        arry[i] = base;
        //基准数在这里递归就为了左边的数比它小，右边的数比它大
        //排序基准数的左边
        quickSort(arry, left, i - 1);
        //排右边
        quickSort(arry, j + 1, right);

    }
}
