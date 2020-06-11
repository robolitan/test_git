package ua.patterns.behavior.observer;

public interface Notificable {
    void register(Consumer consumer);
    void notification() throws InterruptedException;
    void removeConsumer(Consumer consumer);
}
