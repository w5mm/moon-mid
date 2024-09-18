package threadPractice;

public class CreatThread {


    public static void main(String[] args) {
        Thread.currentThread().setName("main thread");
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "前面" + i);
        }

        myThread1.setName("sub Thread A:");
        myThread2.setName("sub Thread B:");

        myThread1.start();
        myThread2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "后面" + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

