package pratise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        new CompletableFutureTest().CompletableTest();

        new CompletableFutureTest().CompletableTest2();



    }
    public void CompletableTest() throws InterruptedException, ExecutionException {
        long userId =666L;
        long startTime = System.currentTimeMillis();

        //调用用户服务获取用户基本信息
        CompletableFuture.runAsync(() -> {
            System.out.printf("第1次");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        CompletableFuture.runAsync(() -> {
            System.out.printf("第2次");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        CompletableFuture.supplyAsync(() -> {

            System.out.printf("第3次");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  "成功了";
        });

        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        });

        Thread.sleep(300); //模拟主线程其它操作耗时
        String result = future.get();
        System.out.println(result);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }
    public void CompletableTest2() throws InterruptedException {

        long startTime = System.currentTimeMillis();
        System.out.printf("第1次");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("第2次");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("第3次");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(300); //模拟主线程其它操作耗时


        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }


}
