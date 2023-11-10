package pratise;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableFutureTest {

    public static  void main(String[] args) throws Exception {
        CallableTest testFuture = new CallableTest();
        FutureTask<Integer> futureTask  = new FutureTask<Integer>(testFuture);
        for(int i = 0; i < 10; i++) {
            System.out.printf(Thread.currentThread().getName() + "名称的线程开始执行\n"+i);
            if(i==8){
                Thread td =  new Thread((Runnable) testFuture,"CallableThread");
                td.start();
            }
        }
        System.out.println("子线程的返回值为" + futureTask.get());







    }

    static class CallableTest implements Callable<Integer> {

        public Integer call() throws Exception {
            int i = 0;
            for (; i < 10; i++) {
                System.out.println("Callable Thread : " + i);
            }
            return i;
        }
    }
}
