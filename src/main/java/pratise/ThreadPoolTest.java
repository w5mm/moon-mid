package pratise;

import java.util.concurrent.*;


public class ThreadPoolTest {
    private static ExecutorService es =  new ThreadPoolExecutor(10, 10, 1000,
            TimeUnit.MICROSECONDS, new java.util.concurrent.ArrayBlockingQueue<Runnable>(10));

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task1 = new FutureTask<Integer>(( ) -> {
            System.out.println(" -- task1 start");
            Thread.sleep(2000);
            System.out.println(" -- task1 end");
            return 1;
        });
        FutureTask<Integer> task2 = new FutureTask<Integer>(( ) -> {
            System.out.println(" -- task2 start");
            Thread.sleep(2000);
            System.out.println(" -- task2 end");
            return 2;
        });

        FutureTask<Integer> task3 = new FutureTask<Integer>(( ) -> {
            System.out.println(" -- task3 start");
            Thread.sleep(2000);
            System.out.println(" -- task3 end");
            return 2;
        });
        es.submit(task1);
        es.submit(task2);
        es.submit(task3);
        task1.get();
        task2.get();
        task3.get();
        es.isShutdown();
        System.out.printf("线程执行完成" );


    }



}
