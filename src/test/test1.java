package test;

public class test1 {
    public static void main(String[] args) {
        Father a = new Father();
        Father b = new Child();
        float[] f[][][] = new float[6][][][];
        int x = 0, y = 1;
    }
}

class Father {
    public Father() {
        System.out.println("我是父类");
    }
}

class Child extends Father {
    public Child() {
        System.out.println("我是子类");
    }
}