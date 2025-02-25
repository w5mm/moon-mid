package threadPractice;

public class RunnableTest {

    public static void main(String[] args) {
        Thread.currentThread().setName("main thread:");
        Thread thread = new Thread(new MyRunnable());
        thread.setName("myThread:");
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

}
class  MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
