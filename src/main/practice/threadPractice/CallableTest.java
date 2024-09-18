package threadPractice;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask  = new FutureTask<Integer>( new MyCallable());
        new Thread(futureTask).start();
        try {
            System.out.println("子线程的返回值为" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println("Callable Thread : " + i);
        }
        return i;
    }
}
