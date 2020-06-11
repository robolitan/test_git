package ua.multithreading.concurrent.exchanger;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainExchanger {
    public static void main(String[] args) throws InterruptedException {
        Exchanger exchanger = new Exchanger();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Sender(exchanger));
        service.execute(new Receiver(exchanger));
        TimeUnit.SECONDS.sleep(10);
        service.shutdownNow();
    }
}

class Sender implements Runnable{
    Exchanger<String> exchanger;
    public Sender(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                String exchange = exchanger.exchange(Character.valueOf((char) new Random().nextInt(65000)).toString());
                System.out.println(this.getClass().getName() + " - " + exchange);
            } catch (InterruptedException e) {
                System.out.println("Was interrupt by service.interrupt");
                e.printStackTrace();
            }
        }
    }
}

class Receiver implements Runnable{
    Exchanger<String> exchanger;

    public Receiver(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                String exchange = exchanger.exchange("i receive it");
                System.out.println(this.getClass().getName() + " - " + exchange);
            } catch (InterruptedException e) {
                System.out.println("Was interrupt by service.interrupt");
                e.printStackTrace();
            }
        }
    }
}
