package ua.multithreading.base;

import java.util.concurrent.Executors;

public class MainThread {
    public static void main(String[] args) {
        new Thread(MainThread::doWork, "thread-from-main").start();
        Executors.newCachedThreadPool();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    private static void doWork() {
        System.out.println("Hi");
    }
}

