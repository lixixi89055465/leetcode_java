package baidu;

import java.util.*;

public class Test04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        if (a == null || a.isEmpty()) {
            return;
        }
        String[] split = a.split(",");
        HashMap<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].trim().length()>0){
                countMap.put(split[i], countMap.getOrDefault(split[i], 0) + 1);
            }
        }
        System.out.println(a);
        countMap.forEach((e, v) -> {
            if (v > split.length / 2) {
                System.out.println(e);
                return;
            }
        });

    }
}
