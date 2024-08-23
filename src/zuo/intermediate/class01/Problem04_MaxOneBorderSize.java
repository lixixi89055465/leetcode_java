package zuo.intermediate.class01;

/**
 * 给定一个N*N的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的边
 * 长长度。
 * 例如:
 * 01111
 * 01001
 * 01001
 * 01111
 * 01011
 * 其中边框全是1的最大正方形的大小为4*4，所以返回4
 */
public class Problem04_MaxOneBorderSize {

    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int r01() {
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    public static int g() { //1~7
        int res = 0;
        do {
            res = (r01() << 2) + (r01() << 1) + r01();
        } while (res == 7);
        return res + 1;
    }

    public static int rand01p() {
        //
        double p = 0.83;
        return p > Math.random() ? 1 : 0;
    }

    /**
     * 利用 任意随机函数获取等分概率函数
     *
     * @return
     */
    public static int rand01() {
        int num;
        do {
            num = (rand01p() << 1) + (rand01p());
        } while (num == 0 || num == 3);
        return num == 1 ? 1 : 0;
    }


    public static void main(String[] args) {
    }
}
