package luogu.P33;

/**
 * @PackageName:luogu.P33
 * @Date 2023/9/12 16:23
 * @Description: （洛谷P3372 【模板】线段树 1）
 * <p>
 * 题目描述
 * 如题，已知一个数列，你需要进行下面两种操作：
 * 1.将某区间每一个数加上x
 * 2.求出某区间每一个数的和
 * 输入格式
 * 第一行包含两个整数N、M，分别表示该数列数字的个数和操作的总个数。
 * 第二行包含N个用空格分隔的整数，其中第i个数字表示数列第i项的初始值。
 * 接下来M行每行包含3或4个整数，表示一个操作，具体如下：
 * 操作1： 格式：1 x y k 含义：将区间[x,y]内每个数加上k
 * 操作2： 格式：2 x y 含义：输出区间[x,y]内每个数的和
 * 输出格式
 * 输出包含若干行整数，即为所有操作2的结果。
 */
public class P3372 {
    public void buildSegmentTree(int L, int R, int[] tree, int P, int[] A) {
        if (L == R) {
            tree[P] = A[L];
        } else {
            int mid = L + (R - L) / 2;
            buildSegmentTree(L, mid, tree, P * 2, A);
            buildSegmentTree(mid, R, tree, P * 2 + 1, A);
            tree[P] = tree[P * 2] + tree[P * 2 + 1];
        }
    }

    public static void main(String[] args) {

    }
}
