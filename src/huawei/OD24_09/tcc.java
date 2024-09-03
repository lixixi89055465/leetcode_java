package huawei.OD24_09;

/**
 * https://www.nowcoder.com/discuss/599714824850857984?sourceSSR=search
 * 特定大小的停车场，replace数组cars[]表示，其中1表示有车，0表示没车。
 * <p>
 * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3），统计停车场最少可以停多少辆车，返回具体的数目。
 * <p>
 * 输入描述
 * 整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
 * <p>
 * 输出描述
 * 整型数字字符串，表示最少停车数目。
 * <p>
 * 示例1
 * 输入：
 * 1,0,1
 * <p>
 * 输出：
 * 2
 * <p>
 * 说明：
 * 1个小车占1个车位
 * 第二个车位空
 * 1个小车占3个车位最少有两辆车
 * 示例2
 * 输入：
 * 1,1,0,0,1,1,1,0,1
 * <p>
 * 输出：
 * 3
 * <p>
 * 说明：
 * 1个货车占第1、2个车位
 * 第3、4个车位空
 * 1个卡车占第5、6、7个车位
 * 第8个车位空
 * 1个小车占第9个车位
 * 最少3辆车
 * <p>
 * 作者：code5bug
 * 链接：https://www.nowcoder.com/discuss/599714824850857984?sourceSSR=search
 * 来源：牛客网
 */
public class tcc {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        int pre = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                pre++;
            } else if (pre > 0) {
                result += (pre / 3);
                pre %= 3;
                result += (pre / 2);
                pre %= 2;
                result += pre;
                pre = 0;
            }
        }
        if (pre > 0) {
            result += (pre / 3);
            pre %= 3;
            result += (pre / 2);
            pre %= 2;
            result += pre;
        }
        System.out.println(result);
    }
}
