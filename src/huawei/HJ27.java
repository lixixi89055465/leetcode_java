package huawei;

import java.util.*;

/**
 * HJ27 查找兄弟单词
 */
public class HJ27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        ArrayList<String> strs = new ArrayList<>();
        String base = inputs[n + 1];
        int sIndex = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!inputs[i].equals(base) && isBrothers(base, inputs[i])) {
                strs.add(inputs[i]);
            }
        }
        int lastInt = Integer.parseInt(inputs[n + 2]);
        strs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(strs.size());
        if (strs.size() >= lastInt) {
            System.out.println(strs.get(lastInt - 1));
        }
    }

    private static boolean isBrothers(String base, String input) {
        if (base.length() != input.length()) {
            return false;
        }
        HashMap<Character, Integer> baseMap = new HashMap<>();
        HashMap<Character, Integer> inputMap = new HashMap<>();
        for (char c : base.toCharArray()) {
            baseMap.put(c, baseMap.getOrDefault(c, 0) + 1);
        }
        for (char c : input.toCharArray()) {
            inputMap.put(c, inputMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : baseMap.entrySet()) {
            if (entry.getValue() != inputMap.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }

        return true;
    }
}
