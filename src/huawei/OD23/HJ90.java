package huawei.OD23;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

public class HJ90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.next();
        String[] ipS = ip.split("\\.");

        if (ipS == null || ipS.length != 4) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(ipS[i].isEmpty()){
                System.out.println("NO");
                return;
            }
            if(ipS[i].length()>1&&ipS[i].charAt(0)=='0'){
                System.out.println("NO");
                return;
            }
            for (int j = 0; j < ipS[i].length(); j++) {
                 if('0'>ipS[i].charAt(j)||'9'<ipS[i].charAt(j)){
                     System.out.println("NO");
                     return;
                 }
            }

            int i1 = Integer.parseInt(ipS[i]);
            if (i1 >= 0 &&i1 <= 255){
               continue;
            }else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
