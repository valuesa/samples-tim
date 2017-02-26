package cn.boxfish.thinking.concurrent21.executors;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by TIM on 2017/2/26.
 */
public class ExecutorsDemo {

    @Test
    public void reject() throws InterruptedException {
        long threadId = Thread.currentThread().getId();
        System.out.println("currentTHread: " + threadId);
        // 当队列满的时候， 直接在调用者线程中调用Runnable.run()方法， 所以这个时候如果有个异常， 线程因为异常退出， 后面的任务也执行不了了
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(2, 2, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(2), new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i = 0; i < 100; i++) {
            final int finalI = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getId() + ": " + finalI);
                    if(threadId == Thread.currentThread().getId()) {
                        throw new RuntimeException("interruptedException!!");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }
    }
}
