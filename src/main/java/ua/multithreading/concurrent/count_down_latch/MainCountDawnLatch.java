package ua.multithreading.concurrent.count_down_latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainCountDawnLatch {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            service.execute(new SomePartOfOuterTask(countDownLatch,i));
        }
        service.execute(new MainTask(1, countDownLatch));
        service.shutdown();
    }
}

class SomePartOfOuterTask implements Runnable{
    private final int id;
    private final CountDownLatch countDownLatch;

    public SomePartOfOuterTask(CountDownLatch countDownLatch, int id) {
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2*new Random().nextInt(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.someWork();
        countDownLatch.countDown();
    }

    private void someWork(){
        System.out.println("Task - " + id + " - finish his work");
    }
}

class MainTask implements Runnable{
    private final int id;
    private final CountDownLatch countDownLatch;

    public MainTask(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main task is done his work");
    }
}
