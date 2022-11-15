package zuo.senior.class01;

public class test {
    public static void main(String[] args) {

        int e1=10;
        int s1=2;
        int offset = ((e1 - s1 + 1) & 1) ^ 1;
        System.out.println(offset);
    }
}
