package csa.stu.app.common.test;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestExecutors {

    public static void main(String[] s){
        ScheduledExecutorService executorService =  Executors.newScheduledThreadPool(3);
         executorService.scheduleWithFixedDelay(()->{
             try {
                 Thread.sleep(3000);
                 System.out.println("我是谁...");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },0,2,TimeUnit.SECONDS);
    }


}
