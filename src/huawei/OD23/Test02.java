package huawei.OD23;

public class Test02 {
    public static void main(String[] args) {
//        int a = 12;
        int a = 1;
        int b = a & (~a + 1);
        System.out.println(b);
    }
}
