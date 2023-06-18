package huawei;


import java.util.*;

public class HJ41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");
        int[] marr = new int[n];
        int[] xarr = new int[n];
        for (int i = 0; i < s1.length; i++) {
            marr[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < s2.length; i++) {
            xarr[i] = Integer.parseInt(s2[i]);
        }
        Set<Integer> set = new TreeSet<Integer>();
        set.add(0);
        for (int i = 0; i < marr.length; i++) {
            int curSize = set.size();
            for (int j = 1; j <= xarr[i]; j++) {
                for (int k = 0; k < curSize; k++) {
//                    int cur = set.get(k) + marr[i] * j;
//                    if (!set.contains(cur)) {
//                        set.add(cur);
//                    }
                }
            }
        }
        HashSet<Integer> resSet = new HashSet<>(set);
        System.out.println(resSet.size());
    }
}
