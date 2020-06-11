package ua.multithreading.base.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPriority {
    public static void main(String[] args) {
        System.out.println("START");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            executorService.execute(new RunnableTask(Thread.MIN_PRIORITY));
        }
        executorService.execute(new RunnableTask(9));
        System.out.println("FINISH OF MAIN");
    }
}

class RunnableTask implements Runnable {
    private int priority;
    private static int countID = 0;
    private final int ID = countID++;
    private int countDown = 10;

    @Override
    public String toString() {
        return Thread.currentThread().toString() + ":" + ID + "#" + countDown;
    }

    public RunnableTask(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(ID+"");
        Thread.currentThread().setPriority(priority);
        while (countDown-- > 0) {
            System.out.println(this);
        }
    }
}