package zuo.interview_question.class102;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tset1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        List<String> result=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str1=scanner.next();
            String ans=getResult(str1);
            result.add(ans);
        }
        result.forEach(System.out::println);
    }

    private static String getResult(String str1) {
        StringBuilder sb = null;
        int count = 0;
        while (true) {
            sb = new StringBuilder();
            for (int i = 0; i < str1.length(); i++) {
                if (i == str1.length() - 1) {
                    sb.append(str1.charAt(i));
                } else if (str1.charAt(i) == str1.charAt(i + 1)) {
                    i++;
                    count += 1;
                } else {
                    sb.append(str1.charAt(i));
                    if (i == str1.length() - 1) {
                        sb.append(str1.charAt(i + 1));
                    }
                }
            }
            if (str1.equals(sb.toString())) {
                break;
            }
            str1 = sb.toString();
        }
        if ((count & 1) == 0) {
            return "No";
        } else {
            return "Yes";
        }
    }

}
