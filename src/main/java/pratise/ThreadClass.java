package pratise;

public class ThreadClass extends Thread {
    @Override
    public  void run() {
        System.out.printf("thread " +Thread.currentThread().getName() );
    }
}
