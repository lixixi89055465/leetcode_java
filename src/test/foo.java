package test;

import java.io.*;
import java.util.*;

public class foo {
    public static void main(String args[]) {

        String i3="100";
        String i4="1"+new String("00");
        System.out.println((i3==i4));
        System.out.println(i3.equals(i4));
        System.out.println(i3.intern() == i4);
        System.out.println(i3 == i4.intern());

    }
}