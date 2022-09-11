package base.class11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Code03_PrintAllPermutations {
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    private static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && str[i + 1] <= '6' && str[i + 1] >= '0') {
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
    }
}
