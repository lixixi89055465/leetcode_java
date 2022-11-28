package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.concurrent.*;

public class Test2 {

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> result1 = pool.submit(() -> {
            int ans = 0;
            for (int i = 1; i < 5000; i++) {
                ans += i;
            }
            return ans;
        });
        Future<Integer> result2 = pool.submit(() -> {
            int ans = 0;
            for (int i = 5000; i < 10000; i++) {
                ans += i;
            }
            return ans;
        });
        System.out.println(result1.get() + result2.get());
    }
}
