package huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class HJ82 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Character> tr = new HashMap<>();
        tr.put('0', '0');
        tr.put('1', '8');
        tr.put('2', '4');
        tr.put('3', 'C');
        tr.put('4', '2');
        tr.put('5', 'A');
        tr.put('6', '6');
        tr.put('7', 'E');
        tr.put('8', '1');
        tr.put('9', '9');
        tr.put('a', '5');
        tr.put('b', 'D');
        tr.put('c', '3');
        tr.put('d', 'B');
        tr.put('e', '7');
        tr.put('f', 'F');
        tr.put('A', '5');
        tr.put('B', 'D');
        tr.put('C', '3');
        tr.put('D', 'B');
        tr.put('E', '7');
        tr.put('F', 'F');
        while (sc.hasNext()) {
            String a = sc.nextLine();
            int i = 0, length = a.length();
            ArrayList<Character> a1 = new ArrayList<>();
            ArrayList<Character> a2 = new ArrayList<>();
            for (char c : a.toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                if ((i & 1) == 0) {
                    a1.add(c);
                } else {
                    a2.add(c);
                }
                i++;
            }
            //分别排序
            a1.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1 - o2;
                }
            });
            a2.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1 - o2;
                }
            });
            //按照十六进制表替换
            StringBuilder sb = new StringBuilder();
            length = a1.size() + a2.size();
            for (i = 0; i < length; i++) {
                char c;
                if ((i & 1) == 0) {
                    c = a1.get(i / 2);
                } else {
                    c = a2.get(i / 2);
                }
                if (('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F')) {
                    c = tr.get(c);
                }
                sb.append(c);
            }
            System.out.println(sb.toString());

        }
    }
}
