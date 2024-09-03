package huawei.OD23;

public class Test04 {
    public static void main(String[] args) {

        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);
        Integer i3 = 100;
        Integer i4 = 100;
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i1 == i4);
        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);
        System.out.println(i3 == i4);

    }
}
