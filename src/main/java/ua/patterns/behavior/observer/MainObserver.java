package ua.patterns.behavior.observer;

import java.util.Date;

public class MainObserver {
    public static void main(String[] args) throws InterruptedException {

        TestObserveHolder holder = new TestObserveHolder();

        ConsumerImpl_1 consumerImpl_1 = new ConsumerImpl_1();
        ConsumerImpl_2 consumerImpl_2 = new ConsumerImpl_2();
        holder.register(consumerImpl_1);
        holder.register(consumerImpl_2);
        Thread.sleep(2000);
        Date date = new Date();
        holder.setDate(date);

    }

}
