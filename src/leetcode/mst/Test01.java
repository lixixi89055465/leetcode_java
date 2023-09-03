package leetcode.mst;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test01 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<Integer>();
        set1.addAll(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<Integer>();
        set2.addAll(Arrays.asList(3, 4, 5, 6));
//        set1.addAll(set2);
//        System.out.println(set1);
//        set1.removeAll(set2);
        System.out.println(set1);


    }
}
