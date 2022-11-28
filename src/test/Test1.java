package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {

    public static void main(String args[]) throws InterruptedException {
        List<Integer>arr=new ArrayList<>(7);
        arr.addAll(Arrays.asList(1, 2, 6, 6, 8, 10, 1 ));
        for (int i = arr.size()-1 ; i >=0; i--) {
            if(arr.get(i)==1){
                arr.remove(i);
            }
        }
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }

}
