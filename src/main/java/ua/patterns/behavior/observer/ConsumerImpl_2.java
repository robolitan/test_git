package ua.patterns.behavior.observer;

import java.util.Date;

public class ConsumerImpl_2 implements Consumer {
    private Date date = new Date();

    @Override
    public void update(Date date) throws InterruptedException {
        System.out.println(this.getClass() + " - before - " + this.date);
        this.date = date;
        System.out.println(this.getClass() + " - after - " + this.date);
    }
}
