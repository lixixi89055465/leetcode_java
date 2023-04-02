package dp;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;

public class Test01 {
    public static String[] toByteArray(int value) {
        // write code here
        int n=value;
        StringBuilder sb=new StringBuilder();
        ArrayList<Byte> result = new ArrayList<>();
        while (n%128>0){
            result.add(Byte.parseByte(n%128+""));
            n/=128;
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.indexOf(i));
        }
        return null;
    }

//    public static void main(String[] args) {
//        System.out.println(toByteArray(1));
//    }
public static void main(String[] args) {

}
}
