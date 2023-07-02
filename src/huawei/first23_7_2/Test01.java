package huawei.first23_7_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String split = sc.nextLine();
            String[] splits = split.split(" ");
            map.put(splits[1], splits[0]);
        }
        String[] chs = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            set.add(chs[i]);
        }
        for (int i = 0; i < chs.length; i++) {
            if (set.contains(map.get(chs[i]))) {
                continue;
            }
            sb.append(chs[i]+" ");
        }
        System.out.println(sb.toString());


    }
}
