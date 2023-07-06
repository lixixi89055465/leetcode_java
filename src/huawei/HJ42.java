package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ42 {
    private static Map<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "one");
        map.put(2L, "two");
        map.put(3L, "three");
        map.put(4L, "four");
        map.put(5L, "five");
        map.put(6L, "six");
        map.put(7L, "seven");
        map.put(8L, "eight");
        map.put(9L, "nine");
        map.put(10L, "ten");
        map.put(11L, "eleven");
        map.put(12L, "twelve");
        map.put(13L, "thirteen");
        map.put(14L, "fourteen");
        map.put(15L, "fifteen");
        map.put(16L, "sixteen");
        map.put(17L, "seventeen");
        map.put(18L, "eighteen");
        map.put(19L, "nineteen");
        map.put(20L, "twenty");
        map.put(30L, "thirty");
        map.put(40L, "forty");
        map.put(50L, "fifty");
        map.put(60L, "sixty");
        map.put(70L, "seventy");
        map.put(80L, "eighty");
        map.put(90L, "ninety");
    }

    public static void main(String[] args) {

        //1000一下
        Scanner sc = new Scanner(System.in);
//        long n = Long.parseLong(sc.nextLine());
//        Long n = 22L;
//        Long n = 100L;
//        Long n = 145L;
//        Long n = 1234L;
//        Long n = 8088L;
//        Long n = 486669L;
        Long n = sc.nextLong();
        String res1 = getThousand(n % 1000);
        n /= 1000;
        if (n > 0) {
            res1 = getThousand(n % 1000) + " thousand " + res1;
        }
        n /= 1000;
        if (n > 0) {
            res1 = getThousand(n % 1000) + " million " + res1;
        }
        System.out.println(res1);
    }

    private static String getThousand(long num) {
        if (num <= 0) {
            return "";
        }
        String res = "";
        long shi = num % 100;
        if (shi > 0 && shi < 20) {
            res += map.get(shi) ;
        } else if (shi >= 20) {
            res += map.get(shi - shi % 10) + (shi % 10 == 0 ? "" :  " "+map.get(shi % 10));
        }
        long bai = num % 1000;
        if (bai >= 100) {
            res = map.get(bai / 100) + " hundred " + (res.length() == 0 ? res : "and " + res);
        }
        return res;
    }
}
