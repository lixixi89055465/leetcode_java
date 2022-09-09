package test;

public class Arraytest{
    private static int a[] = new int[6];
    public static void main ( String arg[] ) {
        Integer i = 42;
        Long l = 42l;
        Double d = 42.0;
        System.out.println(d.equals(l));
        System.out.println(l.equals(i));
    }
}