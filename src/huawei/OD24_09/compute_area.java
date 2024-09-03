package huawei.OD24_09;

import java.util.Scanner;

/**
 * 计算面积 - 华为OD统一考试（C卷）
 *
 * 题目描述
 * 绘图机器的绘图笔初始位置在原点（0, 0），机器启动后其绘图笔按下面规则绘制直线：
 * <p>
 * 1）尝试沿着横向坐标轴正向绘制直线，直到给定的终点值E。
 * <p>
 * 2）期间可通过指令在纵坐标轴方向进行偏移，并同时绘制直线，偏移后按规则1 绘制直线；指令的格式为X offsetY，表示在横坐标X 沿纵坐标方向偏移，offsetY为正数表示正向偏移，为负数表示负向偏移。
 * <p>
 * 给定了横坐标终点值E、以及若干条绘制指令，请计算绘制的直线和横坐标轴、以及 X=E 的直线组成图形的面积。
 * <p>
 * 输入描述
 * 首行为两个整数N E，表示有N条指令，机器运行的横坐标终点值E；
 * <p>
 * 接下来N行，每行两个整数表示一条绘制指令X offsetY，用例保证横坐标X以递增排席方式出现，目不会出现相同横坐标X；
 * <p>
 * 取值范围: 0<N<=10000，0<= X<=E<=20000,-10000 <= offsetY <= 10000。
 * <p>
 * 输出描述
 * 一个整数，表示计算得到的面积，用例保证，结果范围在0~4294967295内
 * <p>
 * 示例1
 * 输入：
 * 4 10
 * 1 1
 * 2 1
 * 3 1
 * 4 -2
 * <p>
 * 输出：
 * 12
 * <p>
 * 作者：code5bug
 * 链接：https://www.nowcoder.com/discuss/595648285843402752
 * 来源：牛客网
 */
public class compute_area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int endX = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int[] pre = new int[2];
        pre[0] = -1;
        int[] cur = new int[2];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            cur[0] = arr[i][0];
            cur[1] = pre[1] + arr[i][1];
            sum += Math.abs(pre[1]) * (cur[0] - pre[0]);
            pre[0] = cur[0];
            pre[1] = cur[1];
        }
        if (endX > cur[0]) {
            sum += (endX-cur[0]) * Math.abs(cur[1]);
        }
        System.out.println(sum);
    }

}
