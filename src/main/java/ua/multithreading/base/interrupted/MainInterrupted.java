package ua.multithreading.base.interrupted;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new BlockedTask());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Using t.interrupt");
        thread.interrupt();
    }
}

class BlockedMutex {
    Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
    }

    public void f() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println("Interrupted with f()");
        }
    }
}

class BlockedTask implements Runnable {
    BlockedMutex mutex = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for ");
        mutex.f();
        System.out.println("After waiting");
    }
}