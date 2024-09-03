package zuo.intermediate.class03;

/**
 * 假设s和m初始化，s = "a"; m = s;
 * 再定义两种操作，第一种操作：
 * m = s;
 * s = s + s;
 * 第二种操作：
 * s = s + m;
 * 求最小的操作步骤数，可以将s拼接到长度等于n
 */
public class Problem06_SplitNbySM {
    public static boolean isPrim(int n) {
        if (n < 2) {
            return false;
        }
        int max = (int) Math.sqrt((double) n);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] divSumAndCount(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                count++;
                n /= i;
            }
        }
        return new int[]{sum, count};
    }
    public static int minOps(int n){
        if(n<2){
            return 0;
        }
        if(isPrim(n)){
            return n-1;
        }
        int []divSumAndCount=divSumAndCount(n);
        return divSumAndCount[0]-divSumAndCount[1];
    }

}
