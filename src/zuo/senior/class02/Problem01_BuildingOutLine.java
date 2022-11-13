package zuo.senior.class02;

import java.util.TreeMap;

public class Problem01_BuildingOutLine {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(6, "我是6");
        map.put(3, "我是3");
        map.put(9, "我是9");
        map.put(1, "我是1");
        map.put(2, "我是2");
        map.put(5, "我是5");
        map.put(1, "我是1");
        System.out.println(map.containsKey(5));
        System.out.println(map.remove(5));
        System.out.println(map.containsKey(5));
        System.out.println(map.get(9));

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        //查询<=num，离这个num最近的key是谁
        System.out.println(map.floorKey(5));
        //查询>=num，离这个num最近的key是谁
        System.out.println(map.floorKey(5));

        //所有的方法，性能O{logN}

    }
}
