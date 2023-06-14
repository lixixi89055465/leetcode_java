package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ92 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (sc.hasNext()) {
            process(sc.next());
        }
    }

    private static void process(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int res = 0;
        int len = 0;
        List<String> resStr = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] <= '9' && str[i] >= '0') {
//                sb.append(str[i]);
                len += 1;
                if (i == str.length - 1) {
                    if (len == res) {
                        resStr.add(s.substring(i - len + 1, i + 1));
                    } else if (len > res) {
                        resStr.clear();
                        resStr.add(s.substring(i - len + 1, i + 1));
                        res = Math.max(res, len);
                    }
                }
            } else {
                if (len == res && len > 0) {
                    resStr.add(s.substring(i - len , i ));
                } else if (len > res) {
                    resStr.clear();
                    resStr.add(s.substring(i - len , i ));
                    res = Math.max(res, len);
                }
                len = 0;
            }
        }
        resStr.forEach(e -> {
                    System.out.printf(e);
                }
        );
        System.out.println("," + res);
    }
}
