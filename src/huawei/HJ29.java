package huawei;

import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        char[] mima = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            if ('0' <= ch && ch <= '9') {
                sb.append((ch - '0' + 1 + 10) % 10);
            } else if ('a' <= ch && ch <= 'z') {
                sb.append((char) ((ch - 'a' + 1) % 26 + 'A'));
            } else {
                sb.append((char) ((ch - 'A' + 1) % 26 + 'a'));
            }
        }
        System.out.println(sb.toString());
        sb = new StringBuilder();
        for (char c : mima) {
            if ('0' <= c && c <= '9') {
                sb.append((c - '0' - 1 + 10) % 10);
            } else if ('a' <= c && c <= 'z') {
                sb.append((char) ((c - 'a' - 1 + 26) % 26 + 'A'));
            } else {
                sb.append((char) ((c - 'A' - 1 + 26) % 26 + 'a'));
            }
        }
        System.out.println(sb.toString());
    }
}
