package test;

 

import java.util.concurrent.TimeUnit;

import java.util.stream.LongStream;

 

public class StreamTest {

     public static void main(String[] args) throws InterruptedException {

         long start = System.currentTimeMillis();

         // 流式编程

         long sum = LongStream.rangeClosed( 0 , 10_0000_0000)

                 .parallel().reduce( 0 , Long::sum);

         System.out.println(sum);

 

         System.out.println((System.currentTimeMillis() - start));

 

         TimeUnit.SECONDS.sleep( 100000 ); // 阻塞主线程，让程序不会停止

     }

}