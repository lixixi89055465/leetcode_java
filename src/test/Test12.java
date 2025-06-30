package test;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.Scanner;

public class Test12 {
    /**
     * 3
     * 0 20
     * 1 10
     * 8 20
     *
     *
     * 2
     * 0 255
     * 200 60
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int C= Integer.parseInt(str);
        if(C==0){
            System.out.println(0);
            return;
        }

        int[] Tlist = new int[C];
        int[] Rlist = new int[C];

        for (int i = 0; i < C; i++) {
            String s=in.nextLine();
            String[] split = s.split(" ");
            Tlist[i] = Integer.parseInt(split[0]);
            Rlist[i] = Integer.parseInt(split[1]);
        }
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) {
            int resCode=Rlist[i];
            if (Rlist[i] >= 128) {
                int exp = ((Rlist[i] & 224) >> 5);
                int man = Rlist[i] & 15;
                resCode=((man|0x10)<<(exp+3));
            }

            res=Math.min(res,Tlist[i]+resCode);
        }
        System.out.println(res);

    }
}