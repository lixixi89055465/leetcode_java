package zuo.intermediate.class01;

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
