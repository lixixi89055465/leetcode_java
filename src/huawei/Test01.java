package huawei;

public class Test01 {
    public static void main(String[] args) {
        String str = "0.2.3.8";
        String[] split = str.split("\\.");
        for (int i = 0; i < 4; i++) {
            System.out.println(split[i]);
        }
    }
}
