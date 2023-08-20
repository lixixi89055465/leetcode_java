package test;

import java.util.ArrayList;
import java.util.List;

public class test6 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.subList(1, 3));


    }
}