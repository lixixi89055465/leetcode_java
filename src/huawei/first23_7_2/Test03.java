package huawei.first23_7_2;

import java.util.*;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        String[] errors = sc.nextLine().split(",");
        HashMap<String, List<String>> r_L = new HashMap<>();
        HashMap<String, Integer> strSeqMap = new HashMap<>();
        TreeSet<String> all = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return strSeqMap.get(o1) - strSeqMap.get(o2);
            }
        });
        int seq = 0;
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("\\-");
            if (!strSeqMap.containsKey(split1[0])) {
                strSeqMap.put(split1[0], seq++);
            }
            if (!strSeqMap.containsKey(split1[1])) {
                strSeqMap.put(split1[1], seq++);
            }
            List<String> list = null;
            if (!r_L.containsKey(split1[1])) {
                list = new ArrayList<>();
                r_L.put(split1[1], list);
            }
            list = r_L.get(split1[1]);
            list.add(split1[0]);

            all.add(split1[1]);
            all.add(split1[0]);
        }
        HashSet<String> errorSet = new HashSet<>();
        for (int i = 0; i < errors.length; i++) {
            dfs(errors[i], r_L, errorSet);
        }
        all.removeAll(errorSet);
        if (all.isEmpty()) {
            System.out.println(",");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : all) {
                sb.append(s + ",");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    private static void dfs(String error, HashMap<String, List<String>> r_l, HashSet<String> errorSet) {
        errorSet.add(error);
        List<String> list = r_l.getOrDefault(error, new ArrayList<>());
        list.forEach(e -> {
            if (!errorSet.contains(e)) {
                errorSet.add(error);
                dfs(e, r_l, errorSet);
            }
        });

    }
}
/**
 * a1-a2,a3-a4,a2-a4
 * a4
 */
