package pratise;

public class RunnableTest {
    public static void main(String[] args) {
        RunnableDemo run = new RunnableDemo();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t1.start();
        t2.start();

    }






   static class  RunnableDemo implements Runnable {
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "..." + i);
            }
        }
    }

}


