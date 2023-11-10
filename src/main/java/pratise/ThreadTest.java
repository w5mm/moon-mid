package pratise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {


    public static void main(String[] args) throws InterruptedException {
        ThreadClass testClass = new ThreadClass();
        testClass.start();
        Thread.sleep(100);
        System.out.println("#####################");


    }


    public static void run (String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor  executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public static void test() {
        // 创建一个固定大小的线程池，其中包含5个线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        long pre =  System.currentTimeMillis();
        // 提交任务到线程池
        for (int i = 0; i < 10; i++) {
            final int taskId = i;

            executorService.submit(() -> {
                System.out.println("Task " + taskId + " is running by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Task " + taskId + " has completed"  + "") ;
            });

        }
        long now = System.currentTimeMillis();
        System.out.printf("%d 毫秒",(now - pre));

        // 关闭线程池
        executorService.shutdown();
    }
}
