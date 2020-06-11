package ua.multithreading.concurrent.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MainSemaphore {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Resource resource = new Resource();
        for (int i = 0; i < 4; i++)
            service.execute(new RunTask(resource, "X"));
        service.execute(new RunTask(resource, "Y"));
        System.out.println("Finish");
    }
}

class Resource {
    Semaphore semaphore = new Semaphore(3);

    public String getPrintX() throws InterruptedException {
        try {
            semaphore.acquire();
            return Thread.currentThread() + " - X";
        } finally {
            semaphore.release();
        }
    }

    public String getPrintY() throws InterruptedException {
        try {
            semaphore.acquire();
            return Thread.currentThread() + " - Y";
        } finally {
            semaphore.release();
        }
    }
}

class RunTask implements Runnable {
    Resource resource;
    String string;

    public RunTask(Resource resource, String choose) {
        this.resource = resource;
        this.string = choose;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                if (string.equalsIgnoreCase("Y")) {
                    System.out.println(resource.getPrintY());
                }
                System.out.println(resource.getPrintX());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

