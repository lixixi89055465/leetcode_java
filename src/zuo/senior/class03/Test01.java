package zuo.senior.class03;

public class Test01 {
    private static ThreadLocal<String> id = new ThreadLocal<>();
    private static ThreadLocal<String> phone = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            id.set("2");
            phone.set("654321");
            try {
                Thread.sleep(1000);
                System.out.println(id.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        id.set("1");
        phone.set("123456");
        Thread.sleep(2000);
        System.out.println(id.get());

    }
}

