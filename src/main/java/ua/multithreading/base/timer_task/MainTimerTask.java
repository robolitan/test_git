package ua.multithreading.base.timer_task;

import sun.java2d.loops.TransformHelper;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.Executors.newCachedThreadPool;

public class MainTimerTask {
    private static int ID = 0;
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask - " + ++ID);
            }
        }, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask - " + ++ID);
            }
        }, 3200);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask - " + ++ID);
            }
        }, 3100);
    }
}

class A{
    public synchronized void printX(){}
}

class B extends A{
    @Override
    public  void printX() {
        super.printX();
    }
}