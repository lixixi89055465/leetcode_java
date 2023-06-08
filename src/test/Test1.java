package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static String alternativeMerge2(String str1, String str2) {
        // write code here
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return "";
        }
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(j));
            j = (j + 1) % str2.length();
        }
        return sb.toString();
    }

    public static void main(String args[]) throws InterruptedException {
        String str1 = "abcyokagames", str2 = "12345";
        System.out.println(alternativeMerge2(str1, str2));
    }
}

