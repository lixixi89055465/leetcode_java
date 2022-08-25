package a1400;

import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * 给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 * <p>
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = [1,2,3,4], arr = [2,4,1,3]
 * 输出：true
 * 解释：你可以按照如下步骤使 arr 变成 target：
 * 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
 * 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
 * 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
 * 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
 * 示例 2：
 * <p>
 * 输入：target = [7], arr = [7]
 * 输出：true
 * 解释：arr 不需要做任何翻转已经与 target 相等。
 * 示例 3：
 * <p>
 * 输入：target = [3,7,9], arr = [3,7,11]
 * 输出：false
 * 解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * target.length == arr.length
 * 1 <= target.length <= 1000
 * 1 <= target[i] <= 1000
 * 1 <= arr[i] <= 1000
 */
class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < target.length; i++) {
            if (m.containsKey(target[i])) {
                m.put(target[i], m.get(target[i]) + 1);
            } else {
                m.put(target[i], 1);
            }
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) - 1);
            } else {
                m.put(arr[i], -1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}

public class S1460canBeEqual {
    public static void main(String[] args) {
        Solution1460 solve = new Solution1460();
//        int[] target = new int[]{1, 2, 3, 4};
//        int[] arr = new int[]{2, 4, 1, 3};
//        int[] target = new int[]{7};
//        int[] arr = new int[]{7};

        int[] target = new int[]{3, 7, 9};
        int[] arr = new int[]{3, 7, 11};
        boolean ans = solve.canBeEqual(target, arr);
        System.out.println(ans);


    }
}
