package ua.multithreading.base.usual_creation;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainUsual {
    public static void main(String[] args) {
        System.out.println("start");
        int i = 4;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        do {
            executorService.execute(new LiftOff());
        } while (i-- != 0);
        System.out.println("End of main thread");
    }
}

class LiftOff implements Runnable {
    private int countDown = 10;
    private static int countTask = 1;
    private final int threadId = countTask++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public LiftOff() {
    }

    public void status() {
        System.out.println(threadId + "#("
                + (countDown > 0 ? countDown : "LiftOff") + ") ");
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            status();
            Thread.yield();
        }
    }
}
