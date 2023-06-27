package huawei;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目一：
 * <p>
 * 给出一个数组 list = [1,2,3,4,5,6]
 * <p>
 * 求此数组的所有子集合
 * <p>
 * 输出：[1]，[1,2]，[1,2,3]…
 */
public class subGroup {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add(4);
        ArrayList<List<Integer>> res = subset(list);
        System.out.println(res);
    }

    private static ArrayList<List<Integer>> subset(List<Integer> list) {
        if (list.size() <= 1) {
            ArrayList<List<Integer>> tmp = new ArrayList<>();
            tmp.add(list);
            return tmp;
        }
        Integer remove = list.remove(0);
        ArrayList<List<Integer>> subres = subset(list);
        ArrayList<List<Integer>> res = new ArrayList<>();
        subres.forEach(e -> {
            ArrayList<Integer> tmp = new ArrayList<>();
            e.forEach(e1 -> {
                tmp.add(e1);
            });
            res.add(tmp);
            e.add(0, remove);
            res.add(e);
        });
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(remove);
        res.add(integers);
        return res;
    }

    private static void swap(int[] list, int index1, int index2) {
        int tmp = list[index1];
        list[index1] = list[index2];
        list[index2] = tmp;
    }
}
