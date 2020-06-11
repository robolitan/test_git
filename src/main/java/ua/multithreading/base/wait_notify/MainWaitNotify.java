package ua.multithreading.base.wait_notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Source source = new Source();
        service.execute(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().interrupted()) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        source.canDec();
                        source.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().interrupted()) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        source.increment();
                        source.canIncr();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        TimeUnit.SECONDS.sleep(10);
        service.shutdown();
    }
}

class Source {
    private boolean flag = false;
    private int count = 0;

    synchronized void increment() throws InterruptedException {
        flag = true;
        count++;
        System.out.println(Thread.currentThread().getName() + " - " + count);
        notify();
    }

    synchronized void decrement() throws InterruptedException {
        flag = false;
        count--;
        System.out.println(Thread.currentThread().getName() + " - " + count);
        notify();
    }

    synchronized void canIncr() throws InterruptedException {
        while (flag == true) {
            wait();
        }
    }

    synchronized void canDec() throws InterruptedException {
        while (flag == false) {
            wait();
        }
    }
}

