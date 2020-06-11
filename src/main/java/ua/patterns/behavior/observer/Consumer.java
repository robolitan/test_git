package ua.patterns.behavior.observer;

import java.util.Date;

public interface Consumer {
    void update(Date date) throws InterruptedException;
}
