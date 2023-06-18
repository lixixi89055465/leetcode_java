package huawei;

import java.util.Scanner;


public class HJ39 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mask = sc.nextLine();
        String ip1 = sc.nextLine();
        String ip2 = sc.nextLine();
        System.out.println(process(mask, ip1, ip2));

    }

    private static boolean valid(String ip) {
        String[] ips = ip.split("\\.");
        for (int i = 0; i < ips.length; i++) {
            int tmp = Integer.parseInt(ips[i]);
            if (tmp < 0 || tmp > 255) {
                return false;
            }
        }
        return true;
    }

    private static int process(String mask, String ip1, String ip2) {
        if (!valid(ip1) || !valid(ip2) || !valid(mask) || !validMask(mask)) {
            return 1;
        }
        String[] ip1s = ip1.split("\\.");
        String[] ip2s = ip2.split("\\.");
        String[] masks = mask.split("\\.");
        for (int i = 0; i < 4; i++) {
            int m = Integer.parseInt(masks[i]);
            int p1 = Integer.parseInt(ip1s[i]);
            int p2 = Integer.parseInt(ip2s[i]);
            if ((m & p1) != (m & p2)) {
                return 2;
            }
        }

        return 0;
    }

    private static boolean validMask(String mask) {
        String[] split = mask.split("\\.");
        int flag = 1;
        for (int i = 0; i < 4; i++) {
            int tmp = Integer.parseInt(split[i]);
            if (tmp == 255 && flag == 1) {
                continue;
            } else if (flag == 1) {
                flag = 0;
            } else if (tmp != 0) {
                return false;
            }
        }
        return true;
    }
}
