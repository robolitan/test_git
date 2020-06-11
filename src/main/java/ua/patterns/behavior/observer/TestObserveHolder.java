package ua.patterns.behavior.observer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TestObserveHolder implements Notificable {

    private Set<Consumer> consumerSet = new HashSet<>();
    private Date date = new Date();

    @Override
    public void register(Consumer consumer) {
        consumerSet.add(consumer);
    }

    @Override
    public void notification(){
        consumerSet.stream().forEach(x-> {
            try {
                x.update(date);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void removeConsumer(Consumer consumer) {
        consumerSet.remove(consumer);
    }

    public void setDate(Date date) {
        this.date = date;
        notification();
    }
}
