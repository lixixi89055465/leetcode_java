package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class test02 {
    public static String[] toByteArray(int value) {
        // write code here
        // write code here
        int n = value;
        ArrayList<Integer> result = new ArrayList<>();
        while (n % 129 > 0 && n > 0) {
            int temp = n % 129;
            if (temp == 0) {

            } else {
                n /= 128;
            }
        }
        String[] res = new String[result.size()];
        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i) == 0) {
                res[i] = Integer.toHexString(1);
            } else {
                res[i] = Integer.toHexString(result.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings = toByteArray(128);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

    }

}
