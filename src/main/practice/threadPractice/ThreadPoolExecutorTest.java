package threadPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10) ;
        ThreadPool threadPool = new ThreadPool();
        for(int i = 0 ; i < 10 ; i++) {
            executorService.execute(threadPool);
        }

        executorService.shutdown();

    }
}
class ThreadPool implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
