package luogu.P20;

import java.util.TreeSet;

/**
 * @PackageName:luogu.P20
 * @Date 2023/9/18 10:46
 * @Description:
 */
public class TestTreeSEt {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        // Add elements to TreeSet
        tree.add(10);
        tree.add(5);
        tree.add(8);
        tree.add(1);
        tree.add(11);
        tree.add(3);

        System.out.println(tree.higher(5));
    }

}
