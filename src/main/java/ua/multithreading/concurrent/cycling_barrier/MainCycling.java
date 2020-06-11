package ua.multithreading.concurrent.cycling_barrier;

import java.util.concurrent.*;

public class MainCycling {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(3, ()-> System.out.println("Barrier was come"));
        for (int i = 0; i < 10; i++) {
            service.execute(new SomeAction(barrier, "#" + i));
        }
        TimeUnit.SECONDS.sleep(20);
        service.shutdown();
    }
}

class SomeAction implements Runnable{
    CyclicBarrier barrier;
    String name;

    public SomeAction(CyclicBarrier barrier,String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Name of task - " + name);
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("task(" + name + ") - was finish");
    }
}