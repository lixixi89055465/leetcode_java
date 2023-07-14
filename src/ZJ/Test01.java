package ZJ;

import java.util.Random;

public class Test01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(2));
        }
    }
}
