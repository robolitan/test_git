package ua.multithreading.base.critical_section_with_diff_lock;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainLock {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting...");
                System.exit(-999);
            }
        }, 9000);
        CriticalSection criticalSection = new CriticalSection();
        new Thread(() -> {
            try {
                criticalSection.getObj();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                criticalSection.getObj1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                criticalSection.getObj2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class CriticalSection {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    Lock lock3 = new ReentrantLock();

    public void getObj() throws InterruptedException {
        lock1.lock();
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("obj");
            }
        } catch (Exception e) {

        } finally {
            lock1.unlock();
        }
    }

    public void getObj1() throws InterruptedException {
        lock1.lock();
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("obj1");
            }
        } catch (Exception e) {

        } finally {
            lock1.unlock();
        }
    }

    public void getObj2() throws InterruptedException {
        lock1.lock();
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("obj2");
            }
        } catch (Exception e) {

        } finally {
            lock1.unlock();
        }
    }
}