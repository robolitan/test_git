package ua.multithreading.base.uncaught_exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MainUncaughtException {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadCustomFabric());
        for (int i = 0; i < 4; i++)
            executorService.execute(new Task());
        System.out.println("All thread in work");
        Thread.sleep(2000);
        System.out.println("finish");
        executorService.execute(()-> {while (true) System.out.println("new Task, wont to look for new thread");});
    }
}

class ThreadCustomFabric implements ThreadFactory {
    private static int IDofThread;

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "simply thread - " + ++IDofThread);
        return t;
    }
}

class Task implements Runnable {
    private Thread.UncaughtExceptionHandler handlerException = new MyUncaughtExceptionHandler();

    public void setHandlerException(Thread.UncaughtExceptionHandler handlerException) {
        this.handlerException = handlerException;
    }

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(handlerException);
        if (Thread.currentThread().getName().contains("2")) {
            throw new RuntimeException();
        }
        System.out.println(Thread.currentThread() + " - finish his work");
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("was trouble in thread - " + t + " with problem - " + e.getClass());
    }
}