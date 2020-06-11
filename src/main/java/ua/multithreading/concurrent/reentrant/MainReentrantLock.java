package ua.multithreading.concurrent.reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SomeResource someResource = new SomeResource();
        new Thread(() -> {
            while (true) {
                try {
                    someResource.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - " + SomeResource.x);
            }
        }, "inc").start();

        new Thread(() -> {
            while (true) {
                try {
                    someResource.dec();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - " + SomeResource.x);
            }
        }, "dec").start();

    }
}

class SomeResource {
    ReentrantLock lock = new ReentrantLock();
    Condition isEnough = lock.newCondition();

    static volatile int x = 0;

    public void inc() throws InterruptedException {
        lock.lock();
        while (x != 0) isEnough.await();
        x++;
        isEnough.signalAll();
        lock.unlock();
    }

    public void dec() throws InterruptedException {
        lock.lock();
        while (x > 0) isEnough.await();
        x--;
        isEnough.signalAll();
        lock.unlock();
    }
}

